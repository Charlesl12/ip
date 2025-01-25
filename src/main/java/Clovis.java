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
                    Task task = list.get(index);
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
                list.add(new Task(input));
                System.out.println("added: " + input);
            }
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
