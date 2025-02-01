import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Event extends Task {

    LocalDateTime start;
    LocalDateTime end;
    private final static DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
    private final static DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("MMM/d/yyyy HHmm");

    public Event(String description, String startDateTime, String endDateTime) throws ClovisException{
        super(description);
        try {
            this.start = LocalDateTime.parse(startDateTime, INPUT_FORMAT);
            this.end = LocalDateTime.parse(endDateTime, INPUT_FORMAT);
        } catch (DateTimeParseException e) {
            throw new ClovisException("Invalid date and time format! Use: dd/MM/yyyy HHmm (e.g., 22/6/2000 1600)");
        }
    }

    public Event(String description, boolean isDone, String startDateTime, String endDateTime) {
        super(description, isDone);
        this.start = LocalDateTime.parse(startDateTime, OUTPUT_FORMAT);
        this.end = LocalDateTime.parse(endDateTime, OUTPUT_FORMAT);
    }

    public String toFileFormat() {
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + start.format(OUTPUT_FORMAT) + " | " + end.format(OUTPUT_FORMAT);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(from: " + start.format(OUTPUT_FORMAT) + " to: " + end.format(OUTPUT_FORMAT) + ")";
    }
}
