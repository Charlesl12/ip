package clovis.command;

import clovis.ClovisException;
import clovis.Storage;
import clovis.task.TaskList;
import clovis.Ui;

public abstract class Command {
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws ClovisException;

    public boolean isExit() {
        return false;
    }
}