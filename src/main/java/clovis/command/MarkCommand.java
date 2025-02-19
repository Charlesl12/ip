package clovis.command;

import clovis.ClovisException;
import clovis.Storage;
import clovis.Ui;
import clovis.task.Task;
import clovis.task.TaskList;

/**
 * The {@code MarkCommand} class handles the marking of a task in the task list as completed.
 */
public class MarkCommand extends Command {
    private int index;

    /**
     * Constructs a {@code MarkCommand} instance with the specified index.
     *
     * @param index the index of the task to be marked as completed.
     */
    public MarkCommand(int index) {
        this.index = index;
    }

    /**
     * Executes the marking of a task in the task list as completed, displaying relevant messages,
     * and saving the updated task list to the storage.
     *
     * @param tasks the task list to be manipulated.
     * @param ui the UI for displaying messages.
     * @param storage the storage handler for storing and retrieving of tasks.
     * @return Clovis's response as a String, confirming that the task have been marked as completed.
     * @throws ClovisException If an error occurs while saving the updated task list.
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws ClovisException {
        Task task = tasks.markTask(index, true);
        storage.saveTasks(tasks.getTasks());
        return "Nice! I've marked this task as done:\n" + task;
    }
}
