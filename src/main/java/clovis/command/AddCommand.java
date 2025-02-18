package clovis.command;

import clovis.*;
import clovis.task.Task;
import clovis.task.TaskList;

/**
 * The {@code AddCommand} class represents an abstract add command that add tasks to a task list.
 */
public abstract class AddCommand extends Command {
    protected String description;

    /**
     * Constructs a {@code AddCommand} instance with the specified task description.
     *
     * @param description the description of a task.
     */
    public AddCommand(String description) {
        this.description = description;
    }

    /**
     * Adds a task to the task list, display relevant messages, and saves the updated list to the storage.
     *
     * @param tasks the list of tasks to which the task will be added to.
     * @param ui the UI for displaying messages.
     * @param storage the storage handler for saving tasks.
     * @param task the task to be added.
     * @throws ClovisException if an error occurs while saving the updated tasks.
     */
    public void addTask(TaskList tasks, Ui ui, Storage storage, Task task) throws ClovisException {
        tasks.addTask(task);
        ui.displayMessage("Got it. I've added this task:\n" + task);
        ui.displayMessage("Now you have " + tasks.size() + " tasks in the list.");
        storage.saveTasks(tasks.getTasks());
    }
}
