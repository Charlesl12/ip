package clovis.command;

import clovis.Ui;
import clovis.Storage;
import clovis.ClovisException;

import clovis.task.Task;
import clovis.task.TaskList;

public class UnmarkCommand extends Command {
    protected int index;

    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ClovisException {
        Task task = tasks.markTask(index, false);
        ui.displayMessage("OK, I've marked this task as not done yet:\n" + task);
        storage.saveTasks(tasks.getTasks());
    }
}
