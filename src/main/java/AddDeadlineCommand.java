public class AddDeadlineCommand extends AddCommand {
    private String deadline;

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
