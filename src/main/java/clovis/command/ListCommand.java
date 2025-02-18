package clovis.command;

import clovis.ClovisException;
import clovis.Storage;
import clovis.Ui;
import clovis.task.TaskList;

/**
 * The {@code ListCommand} class handles the listing of tasks in the task list.
 */
public class ListCommand extends Command {
    /**
     * Executes the command by listing all the tasks in the task list.
     *
     * @param tasks the task list to be manipulated.
     * @param ui the UI for displaying messages.
     * @param storage the storage handler for storing and retrieving of tasks.
     * @throws ClovisException never thrown in this implementation.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ClovisException {
        tasks.listTasks();
    }
}
