public class Deadlines extends Task {

    String dateTime;

    public Deadlines(String description, String dateTime) {
        super(description);
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + "(by: " + dateTime + ")";
    }
}
