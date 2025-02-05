public class MarkCommand extends Command {
    private int index;

    public MarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ClovisException {
        Task task = tasks.markTask(index, true);
        ui.displayMessage("Nice! I've marked this task as done:\n" + task);
        storage.saveTasks(tasks.getTasks());
    }
}
