import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Clovis {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Task> list = new ArrayList<>(100);

        System.out.println("Hello! I'm Clovis");
        System.out.println("What can I do for you?");

        while(true) {
            try {
                String input = br.readLine();
                if (input.equalsIgnoreCase("list")) {
                    if (list.isEmpty()) {
                        System.out.println("There are nothing in here");
                    }
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println((i + 1) + ". " + list.get(i));
                    }
                } else if (input.contains("mark")) {
                    String[] markOrUnmark = input.split(" ");
                    int index = Integer.parseInt(markOrUnmark[1]);
                    if (markOrUnmark[0].equalsIgnoreCase("mark")) {
                        System.out.println("Nice! I've marked this task as done:");
                        Task task = list.get(index - 1);
                        task.markAsDone();
                        System.out.println(task);
                    } else if (markOrUnmark[0].equalsIgnoreCase("unmark")) {
                        System.out.println("OK, I've marked this task as not done yet:");
                        Task task = list.get(index);
                        task.markAsNotDone();
                        System.out.println(task);
                    }
                } else if (input.contains("delete")) {
                    String[] deleteIndex = input.split(" ");
                    int index = Integer.parseInt(deleteIndex[1]) - 1;
                    Task task = list.get(index);
                    list.remove(index);
                    System.out.println("Noted. I've removed this task:");
                    System.out.println(task);
                    System.out.println("Now you have " + list.size() + " tasks in the list.");
                } else if (input.equalsIgnoreCase("bye")) {
                    break;
                } else {
                    String[] splitInput = input.split(" ", 2);
                    String taskType = splitInput[0];
                    String description = splitInput.length > 1 ? splitInput[1] : "";
                    if (taskType.equalsIgnoreCase("todo")) {
                        if (description.isEmpty()) {
                            throw new ClovisException("Unacceptable, a description is required for a todo");
                        }
                        list.add(new ToDos(description));
                    } else if (taskType.equalsIgnoreCase("deadline")) {
                        if (description.isEmpty()) {
                            throw new ClovisException("Unacceptable, a description and /by date are required for a deadline");
                        }
                        String[] splitDescription = description.split("/by ", 2);
                        list.add(new Deadlines(splitDescription[0], splitDescription[1]));
                    } else if (taskType.equalsIgnoreCase("event")) {
                        if (description.isEmpty()) {
                            throw new ClovisException("Unacceptable, a description, /from and /to date are required for an event");
                        }
                        String[] splitDescription = description.split("/from | /to ");
                        list.add(new Events(splitDescription[0], splitDescription[1], splitDescription[2]));
                    } else {
                        throw new ClovisException("I have no idea what that means...");
                    }
                    System.out.println("Got it. I've added this task:");
                    Task addedTask = list.get(list.size() - 1);
                    System.out.println("    " + addedTask.toString());
                    System.out.println("Now you have " + list.size() + " tasks in the list.");
                }
            } catch (ClovisException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
