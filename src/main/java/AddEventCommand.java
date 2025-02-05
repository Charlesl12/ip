public class AddEventCommand extends AddCommand {
    private String start;
    private String end;

    public AddEventCommand(String description, String start, String end) {
        super(description);
        this.start = start;
        this.end = end;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ClovisException {
        Task task = new Event(description, start, end);
        addTask(tasks, ui, storage, task);
    }
}
