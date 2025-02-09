package clovis;

import java.util.Scanner;

public class Ui {
    private final Scanner sc;

    public Ui() {
        sc = new Scanner(System.in);
    }

    public void displayWelcome() {
        System.out.println("Hello! I'm clovis.Clovis.\nWhat can I do for you?");
    }

    public String readCommand() {
        return sc.nextLine();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayErrorMessage(String message) {
        System.err.println(message);
    }

    public void displayGoodbye() {
        System.out.println("Bye. Hope to see you again soon!");
    }
}
