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
     * @return Clovis's response as a String, listing all the tasks in the task list.
     * @throws ClovisException never thrown in this implementation.
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws ClovisException {
        if (tasks.isEmpty()) {
            return "List is empty";
        }

        StringBuilder sb = new StringBuilder("Here are the tasks in your list:\n");
        for (int i = 0; i < tasks.size(); i++) {
            sb.append((i + 1)).append(". ").append(tasks.getTask(i + 1)).append("\n");
        }
        return sb.toString();
    }
}
