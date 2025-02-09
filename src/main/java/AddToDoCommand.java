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
