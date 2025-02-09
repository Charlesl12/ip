package clovis.task;

import clovis.ClovisException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {

    LocalDateTime deadline;
    private final static DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
    private final static DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("MMM/d/yyyy HHmm");

    public Deadline(String description, String dateTime) throws ClovisException {
        super(description);
        try {
            this.deadline = LocalDateTime.parse(dateTime, INPUT_FORMAT);
        } catch (DateTimeParseException e) {
            throw new ClovisException("Invalid date and time format! Use: dd/MM/yyyy HHmm (e.g., 22/6/2000 1600)");
        }
    }

    public Deadline(String description, boolean isDone, String dateTime) {
        super(description, isDone);
        this.deadline = LocalDateTime.parse(dateTime, OUTPUT_FORMAT);
    }

    public String toFileFormat() {
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + deadline.format(OUTPUT_FORMAT);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + "(by: " + deadline.format(OUTPUT_FORMAT) + ")";
    }
}
