import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Clovis {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Task> list = Storage.loadTasks();
        System.out.println("Hello! I'm Clovis.\nWhat can I do for you?");

        enum Command {
            TASK, LIST, MARK, UNMARK, DELETE, BYE, UNKNOWN;

            public static Command fromString(String str) {
                return switch (str.toLowerCase()) {
                    case "todo", "deadline", "event" -> TASK;
                    case "list" -> LIST;
                    case "mark" -> MARK;
                    case "unmark" -> UNMARK;
                    case "delete" -> DELETE;
                    case "bye" -> BYE;
                    default -> UNKNOWN;
                };
            }
        }

        while(true) {
            try {
                String input = br.readLine();
                String[] split_input = input.split(" ", 2);
                Command command = Command.fromString(split_input[0]);

                switch(command) {
                    case LIST:
                        if (list.isEmpty()) {
                            System.out.println("There are nothing in here");
                        } else {
                            for (int i = 0; i < list.size(); i++) {
                                System.out.println((i + 1) + ". " + list.get(i));
                            }
                        }
                        break;
                    case BYE:
                        Storage.saveTasks(list);
                        System.out.println("Bye. Hope to see you again soon!");
                        return;
                    case MARK:
                        int mark_index = Integer.parseInt(split_input[1]);
                        System.out.println("Nice! I've marked this task as done:");
                        Task mark_task = list.get(mark_index - 1);
                        mark_task.markAsDone();
                        System.out.println(mark_task);
                        break;
                    case UNMARK:
                        int unmark_index = Integer.parseInt(split_input[1]);
                        System.out.println("OK, I've marked this task as not done yet:");
                        Task unmark_task = list.get(unmark_index - 1);
                        unmark_task.markAsNotDone();
                        System.out.println(unmark_task);
                        break;
                    case DELETE:
                        int index = Integer.parseInt(split_input[1]) - 1;
                        Task task = list.get(index);
                        list.remove(index);
                        System.out.println("Noted. I've removed this task:");
                        System.out.println(task);
                        System.out.println("Now you have " + list.size() + " tasks in the list.");
                        break;
                    case TASK:
                        String taskType = split_input[0];
                        String description = split_input.length > 1 ? split_input[1] : "";
                        if (taskType.equalsIgnoreCase("todo")) {
                            if (description.isEmpty()) {
                                throw new ClovisException("Unacceptable, a description is required for a todo");
                            }
                            list.add(new ToDo(description));
                        } else if (taskType.equalsIgnoreCase("deadline")) {
                            String[] splitDescription = description.split("/by ", 2);
                            list.add(new Deadline(splitDescription[0], splitDescription[1]));
                        } else if (taskType.equalsIgnoreCase("event")) {
                            String[] splitDescription = description.split("/from | /to ");
                            list.add(new Event(splitDescription[0], splitDescription[1], splitDescription[2]));
                        }
                        System.out.println("Got it. I've added this task:");
                        Task addedTask = list.get(list.size() - 1);
                        System.out.println("    " + addedTask.toString());
                        System.out.println("Now you have " + list.size() + " tasks in the list.");
                        break;
                    case UNKNOWN:
                    default:
                        throw new ClovisException("I have no idea what that means...");
                }
                Storage.saveTasks(list);
            } catch (ClovisException e) {
                System.out.println(e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Missing details");
            }
        }
    }
}
