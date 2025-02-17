package clovis.command;

import clovis.Ui;
import clovis.Storage;
import clovis.ClovisException;

import clovis.task.Task;
import clovis.task.TaskList;

public class DeleteCommand extends Command {
    protected int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ClovisException {
        Task task = tasks.deleteTask(index);
        ui.displayMessage("Noted. I've removed this task:\n" + task);
        ui.displayMessage("Now you have " + tasks.size() + " tasks in the list.");
        storage.saveTasks(tasks.getTasks());
    }
}
