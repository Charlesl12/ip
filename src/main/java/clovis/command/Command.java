package clovis.command;

import clovis.ClovisException;
import clovis.Storage;
import clovis.Ui;

import clovis.task.TaskList;

public abstract class Command {
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws ClovisException;

    public boolean isExit() {
        return false;
    }
}