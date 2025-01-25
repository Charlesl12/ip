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
            String input = br.readLine();
            if (input.equalsIgnoreCase("list")) {
                for (int i = 0; i < list.size(); i++) {
                    System.out.println((i+1) + ". " + list.get(i));
                }
            } else if (input.contains("mark")){
                String[] markOrUnmark = input.split(" ");
                int index = Integer.parseInt(markOrUnmark[1]);
                if (markOrUnmark[0].equalsIgnoreCase("mark")) {
                    System.out.println("Nice! I've marked this task as done:");
                    Task task = list.get(index-1);
                    task.markAsDone();
                    System.out.println(task.toString());
                } else if (markOrUnmark[0].equalsIgnoreCase("unmark")) {
                    System.out.println("OK, I've marked this task as not done yet:");
                    Task task = list.get(index);
                    task.markAsNotDone();
                    System.out.println(task.toString());
                }
            } else if (input.equalsIgnoreCase("bye")) {
                break;
            } else {
                String[] splitInput = input.split(" ", 2);
                String taskType = splitInput[0];
                String description = splitInput.length > 1 ? splitInput[1] : "";
                if (taskType.equalsIgnoreCase("todo")) {
                    list.add(new ToDos(description));
                } else if (taskType.equalsIgnoreCase("deadline")) {
                    String[] splitDescription = description.split("/by ", 2);
                    list.add(new Deadlines(splitDescription[0], splitDescription[1]));
                } else if (taskType.equalsIgnoreCase("event")) {
                    String[] splitDescription = description.split("/from | /to ");
                    list.add(new Events(splitDescription[0], splitDescription[1], splitDescription[2]));
                } else {
                    list.add(new Task(input));
                }
                System.out.println("Got it. I've added this task:");
                Task addedTask = list.get(list.size()-1);
                System.out.println("    " + addedTask.toString());
                System.out.println("Now you have " + list.size() + " tasks in the list.");
            }
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
