package clovis;

import java.util.Scanner;

/**
 * The {@code Ui} class handles user interaction by displaying messages and reading user input.
 */
public class Ui {
    private final Scanner sc;

    /**
     * Constructs a {@code Ui} instance and initializes the {@code Scanner} for user input.
     */
    public Ui() {
        sc = new Scanner(System.in);
    }

    /**
     * Displays a welcome message to the user.
     *
     * @return a String containing the welcome message.
     */
    public static String displayWelcome() {
        return "Hello I'm Clovis.\nWhat can I do for you?";
    }

    /**
     * Reads a command input by the user.
     *
     * @return the user's input as a {@code String}.
     */
    public String readCommand() {
        return sc.nextLine();
    }

    /**
     * Displays a message to the user.
     *
     * @param message the message to be displayed.
     */
    public void displayMessage(String message) {
        System.out.println(message);
    }

    /**
     * Displays an error message to the user.
     *
     * @param message the error message to be displayed.
     */
    public void displayErrorMessage(String message) {
        System.err.println(message);
    }

    /**
     * Displays a goodbye message to the user.
     *
     * @return a String containing the goodbye message.
     */
    public String displayGoodbye() {
        return "Bye. Hope to see you again soon!";
    }
}
