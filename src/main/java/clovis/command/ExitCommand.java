package clovis.command;

import clovis.*;
import clovis.task.TaskList;

public class ExitCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ClovisException {
        ui.displayGoodbye();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
