public class Events extends Task {

    String startDateTime;
    String endDateTime;

    public Events(String description, String startDateTime, String endDateTime) {
        super(description);
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(from: " + startDateTime + " to: " + endDateTime + ")";
    }
}
