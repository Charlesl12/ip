public class Deadline extends Task {

    String dateTime;

    public Deadline(String description, String dateTime) {
        super(description);
        this.dateTime = dateTime;
    }

    public Deadline(String description, boolean isDone, String dateTime) {
        super(description, isDone);
        this.dateTime = dateTime;
    }

    public String toFileFormat() {
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + dateTime;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + "(by: " + dateTime + ")";
    }
}
