package clovis.command;

import clovis.Ui;
import clovis.Storage;
import clovis.ClovisException;

import clovis.task.TaskList;

public class ListCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ClovisException {
        tasks.listTasks();
    }
}
