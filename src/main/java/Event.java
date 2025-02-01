public class Event extends Task {

    String startDateTime;
    String endDateTime;

    public Event(String description, String startDateTime, String endDateTime) {
        super(description);
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public Event(String description, boolean isDone, String startDateTime, String endDateTime) {
        super(description, isDone);
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public String toFileFormat() {
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + startDateTime + " | " + endDateTime;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(from: " + startDateTime + " to: " + endDateTime + ")";
    }
}
