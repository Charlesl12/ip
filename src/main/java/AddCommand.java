public abstract class AddCommand extends Command {
    protected String description;

    public AddCommand(String description) {
        this.description = description;
    }

    public void addTask(TaskList tasks, Ui ui, Storage storage, Task task) {
        tasks.addTask(task);
        ui.displayMessage("Got it. I've added this task:\n" + task);
        ui.displayMessage("Now you have " + tasks.size() + " tasks in the list.");
        storage.saveTasks(tasks.getTasks());
    }
}
