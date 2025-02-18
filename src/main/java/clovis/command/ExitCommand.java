package clovis.command;

import clovis.*;
import clovis.task.TaskList;

/**
 * The {@code ExitCommand} class handles exiting the application.
 */
public class ExitCommand extends Command {
    /**
     * Executes the exit command by displaying a goodbye message.
     *
     * @param tasks   the task list (unused in this command).
     * @param ui      the UI for displaying messages.
     * @param storage the storage handler (unused in this command).
     * @throws ClovisException never thrown in this implementation.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ClovisException {
        ui.displayGoodbye();
    }

    /**
     * Indicates that this command will terminate the application.
     *
     * @return {@code true}, signaling the program should exit.
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
