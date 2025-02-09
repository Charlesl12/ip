package clovis.command;

import clovis.*;
import clovis.task.Task;
import clovis.task.TaskList;
import clovis.task.ToDo;

public class AddToDoCommand extends AddCommand {
    public AddToDoCommand(String description) {
        super(description);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ClovisException {
        Task task = new ToDo(description);
        addTask(tasks, ui, storage, task);
    }
}
