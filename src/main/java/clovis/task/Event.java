package clovis.task;

import clovis.ClovisException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * The {@code Event} class represents a task with a specified start date and time, and a specified end date and time.
 */
public class Event extends Task {
    LocalDateTime start;
    LocalDateTime end;
    private final static DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
    private final static DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("MMM/d/yyyy HHmm");

    /**
     * Constructs a {@code Event} instance with the specified description, start date and time, and end date and time.
     *
     * @param description the description of the task.
     * @param startDateTime the start date and time of the task.
     * @param endDateTime the end date and time of the task.
     * @throws ClovisException if date and time format is invalid.
     */
    public Event(String description, String startDateTime, String endDateTime) throws ClovisException {
        super(description);
        try {
            this.start = LocalDateTime.parse(startDateTime, INPUT_FORMAT);
            this.end = LocalDateTime.parse(endDateTime, INPUT_FORMAT);
        } catch (DateTimeParseException e) {
            throw new ClovisException("Invalid date and time format! Use: dd/MM/yyyy HHmm (e.g., 22/6/2000 1600)");
        }
    }

    /**
     * Constructs a {@code Event} instance with the specified description, completion status,
     * start date and time, and end date and time. For storage and retrieval purposes.
     *
     * @param description the description of the task.
     * @param isDone the completion status of the task.
     * @param startDateTime the start date and time of the task.
     * @param endDateTime the end date and time of the task.
     */
    public Event(String description, boolean isDone, String startDateTime, String endDateTime) {
        super(description, isDone);
        this.start = LocalDateTime.parse(startDateTime, OUTPUT_FORMAT);
        this.end = LocalDateTime.parse(endDateTime, OUTPUT_FORMAT);
    }

    /**
     * Returns the string representation of the task formatted for file storage.
     *
     * @return the file format of the task with its task type, completion status, description,
     * start date and time, and end date and time.
     */
    public String toFileFormat() {
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + start.format(OUTPUT_FORMAT) + " | " + end.format(OUTPUT_FORMAT);
    }

    /**
     * Returns the string representation of the task.
     *
     * @return a string containing the task type, status icon, task description,
     * start date and time, and end date and time.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + "(from: " + start.format(OUTPUT_FORMAT) + " to: " + end.format(OUTPUT_FORMAT) + ")";
    }
}
