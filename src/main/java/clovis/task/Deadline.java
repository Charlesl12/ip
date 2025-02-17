package clovis.task;

import clovis.ClovisException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * The {@code Deadline} class represents a task with a specified deadline.
 */
public class Deadline extends Task {
    LocalDateTime deadline;
    private final static DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
    private final static DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("MMM/d/yyyy HHmm");

    /**
     * Constructs a new {@code Deadline} instance with the specified description and deadline.
     *
     * @param description the description of the task.
     * @param dateTime the deadline of the task.
     * @throws ClovisException if the date format is invalid.
     */
    public Deadline(String description, String dateTime) throws ClovisException {
        super(description);
        try {
            this.deadline = LocalDateTime.parse(dateTime, INPUT_FORMAT);
        } catch (DateTimeParseException e) {
            throw new ClovisException("Invalid date and time format! Use: dd/MM/yyyy HHmm (e.g., 22/6/2000 1600)");
        }
    }

    /**
     * Constructs a new {@code Deadline} instance with the specified description, completion status, and deadline.
     * For storage and retrieval purposes.
     *
     * @param description the description of the task.
     * @param isDone the completion status of the task.
     * @param dateTime the deadline of the task in the format "MMM/d/yyyy HHmm".
     */
    public Deadline(String description, boolean isDone, String dateTime) {
        super(description, isDone);
        this.deadline = LocalDateTime.parse(dateTime, OUTPUT_FORMAT);
    }

    /**
     * Returns the string representation of the task formatted for file storage.
     *
     * @return the file format of the task with its task type, completion status, description, and deadline.
     */
    public String toFileFormat() {
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + deadline.format(OUTPUT_FORMAT);
    }

    /**
     * Returns the string representation of the task.
     *
     * @return a string containing the task type, status icon, task description and deadline.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + "(by: " + deadline.format(OUTPUT_FORMAT) + ")";
    }
}
