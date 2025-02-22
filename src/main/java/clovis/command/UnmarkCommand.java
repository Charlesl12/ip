package clovis.command;

import clovis.ClovisException;
import clovis.Storage;
import clovis.Ui;
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
     * @return Clovis's response as a String, confirming that the task have been marked as uncompleted.
     * @throws ClovisException If an error occurs while saving the updated task list.
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws ClovisException {
        validateIndex(index, tasks);
        Task task = tasks.markTask(index, false);
        storage.saveTasks(tasks.getTasks());
        return ui.displayUnmarkMessage(task);
    }

    public void validateIndex(int index, TaskList tasks) throws ClovisException {
        if (index < 1 || index > tasks.size()) {
            throw new ClovisException("Invalid task index!");
        }
    }
}
