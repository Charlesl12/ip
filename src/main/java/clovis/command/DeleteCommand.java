package clovis.command;

import clovis.ClovisException;
import clovis.Storage;
import clovis.Ui;
import clovis.task.Task;
import clovis.task.TaskList;

/**
 * The {@code DeleteCommand} class handles the deletion of a task from a task list.
 */
public class DeleteCommand extends Command {
    protected int index;

    /**
     * Constructs a {@code DeleteCommand} instance with the specified index.
     *
     * @param index the index of the task to be deleted.
     */
    public DeleteCommand(int index) {
        this.index = index;
    }

    /**
     * Executes the deletion of a task, displaying the relevant messages, and save the updated list to the storage.
     *
     * @param tasks the task list to be manipulated.
     * @param ui the UI for displaying messages.
     * @param storage the storage handler for storing and retrieving of tasks.
     * @return Clovis's response as a String, confirming the deletion of the task.
     * @throws ClovisException if an error occurs while saving the updated tasks.
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws ClovisException {
        Task task = tasks.deleteTask(index);
        storage.saveTasks(tasks.getTasks());
        return "Noted. I've removed this task:\n" + task
                + "\nNow you have " + tasks.size() + " tasks in the list.";
    }
}
