public class Clovis {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Clovis(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.loadTasks());
        } catch (ClovisException e) {
            ui.displayErrorMessage(e.getMessage());
            tasks = new TaskList();
        }
    }

    public void run() {
        ui.displayWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String command = ui.readCommand();
                Command c = Parser.parse(command);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (ClovisException e) {
                ui.displayErrorMessage(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Clovis("data/tasks.txt").run();
    }
}
