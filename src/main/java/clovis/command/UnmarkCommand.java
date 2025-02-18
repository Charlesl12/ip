package clovis.command;

import clovis.Ui;
import clovis.Storage;
import clovis.ClovisException;

import clovis.task.Task;
import clovis.task.TaskList;

/**
 * The {@code UnmarkCommand} class handles the marking of a task in the task list as uncompleted.
 */
public class UnmarkCommand extends Command {
    protected int index;

    /**
     * Constructs a {@code UnmarkCommand} instance with the specified index.
     *
     * @param index the index of the task to be marked as uncompleted.
     */
    public UnmarkCommand(int index) {
        this.index = index;
    }

    /**
     * Executes the marking of a task in the task list as uncompleted, displaying relevant messages,
     * and saving the updated task list to the storage.
     *
     * @param tasks the task list to be manipulated.
     * @param ui the UI for displaying messages.
     * @param storage the storage handler for storing and retrieving of tasks.
     * @throws ClovisException If an error occurs while saving the updated task list.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ClovisException {
        Task task = tasks.markTask(index, false);
        ui.displayMessage("OK, I've marked this task as not done yet:\n" + task);
        storage.saveTasks(tasks.getTasks());
    }
}
