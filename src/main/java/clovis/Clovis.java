package clovis;

import clovis.command.Command;
import clovis.task.TaskList;

/**
 * The {@code Clovis} class is the main entry point of the application,
 * responsible for initializing components and running the chatbot.
 */
public class Clovis {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * Constructs a {@code Clovis} instance with the specified file path for storage.
     *
     * @param filePath the path to the file where the tasks are stored.
     */
    public Clovis(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.loadTasks());
        } catch (ClovisException e) {
            ui.displayErrorMessage(e.getMessage());
            tasks = new TaskList();
        }
    }

    /**
     * Runs the main program and processes the user inputs in a loop until an exit command is given.
     */
    public void run() {
        ui.displayWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String command = ui.readCommand();
                Command c = Parser.parse(command);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (ClovisException e) {
                ui.displayErrorMessage(e.getMessage());
            }
        }
    }

    /**
     * The main entry point of the program, initializing and running the chatbot.
     */
    public static void main(String[] args) {
        new Clovis("data/tasks.txt").run();
    }
}
