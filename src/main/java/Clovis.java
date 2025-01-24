import java.util.ArrayList;
import java.util.Scanner;

public class Clovis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>(100);
        System.out.println("Hello! I'm Clovis");
        System.out.println("What can I do for you?\n");
        while(true) {
            String input = sc.nextLine();
            System.out.println("added: " + input);
            if (input.equalsIgnoreCase("list")) {
                for (int i = 0; i < list.size(); i++) {
                    System.out.println((i+1) + ". " + list.get(i));
                }
            } else if (input.equalsIgnoreCase("bye")) {
                break;
            } else {
                list.add(input);
            }
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}
