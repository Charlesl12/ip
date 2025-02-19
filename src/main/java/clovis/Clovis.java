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
     * Processes user input and returns Clovis's response.
     *
     * @param input the user's input command.
     * @return Clovis's response as a String.
     */
    public String getResponse(String input) {
        try {
            Command c = Parser.parse(input);
            return c.execute(tasks, ui, storage);
        } catch (ClovisException e) {
            return e.getMessage();
        }
    }
}
