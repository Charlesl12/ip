package clovis.command;

import clovis.Ui;
import clovis.Storage;
import clovis.ClovisException;

import clovis.task.Deadline;
import clovis.task.Task;
import clovis.task.TaskList;

public class AddDeadlineCommand extends AddCommand {
    protected String deadline;

    public AddDeadlineCommand(String description, String deadline) {
        super(description);
        this.deadline = deadline;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ClovisException {
        Task task = new Deadline(description, deadline);
        addTask(tasks, ui, storage, task);
    }
}
