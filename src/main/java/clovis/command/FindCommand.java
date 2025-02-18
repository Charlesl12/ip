package clovis.command;

import clovis.ClovisException;
import clovis.Storage;
import clovis.Ui;

import clovis.task.Task;
import clovis.task.TaskList;

import java.util.ArrayList;

public class FindCommand extends Command {
    protected String description;

    public FindCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ClovisException {
        ArrayList<Task> matchingTasks = tasks.findTask(description);

        if (matchingTasks.isEmpty()) {
            ui.displayMessage("No tasks matching " + description);
        } else {
            ui.displayMessage("Here are the matching task/task in your list:");
            for (int i = 0; i < matchingTasks.size(); i++) {
                System.out.println((i + 1) + ". " + matchingTasks.get(i));
            }
        }
    }
}