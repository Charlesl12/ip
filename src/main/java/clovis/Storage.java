package clovis;

import clovis.task.Deadline;
import clovis.task.Event;
import clovis.task.Task;
import clovis.task.ToDo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;

/**
 * The {@code Storage} class handles the saving of tasks to a file and retrieval of tasks from a file.
 */
public class Storage {
    private final String filePath;

    /**
     * Constructs a {@code Storage} instance with the specified file path.
     *
     * @param filePath the path to the file.
     */
    public Storage (String filePath) {
        this.filePath = filePath;
    }

    /**
     * Loads tasks from the file specified by {@code filePath}.
     *
     * @return an {@code ArrayList} of tasks loaded from the file.
     * @throws ClovisException if an error occurs while reading the file.
     */
    public ArrayList<Task> loadTasks() throws ClovisException {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(filePath);
        if(!file.exists()) {
            file.getParentFile().mkdirs();
            return tasks;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(" \\| ");
                String taskType = data[0];
                boolean isDone = data[1].equals("1");
                String taskDescription = data[2];

                switch (taskType) {
                    case "T":
                        tasks.add(new ToDo(taskDescription, isDone));
                        break;
                    case "D":
                        tasks.add(new Deadline(taskDescription, isDone, data[3]));
                        break;
                    case "E":
                        tasks.add(new Event(taskDescription, isDone, data[3], data[4]));
                    default:
                        System.out.println("Unknown task type: " + taskType);
                }
            }
        } catch (IOException e) {
            throw new ClovisException("Error loading file: " + e.getMessage());
        }
        return tasks;
    }

    /**
     * Saves tasks into the file specified by {@code filePath}.
     *
     * @param tasks takes a list of tasks to be saved.
     * @throws ClovisException if an error occurs while writing to the file.
     */
    public void saveTasks(ArrayList<Task> tasks) throws ClovisException {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
            for (Task task : tasks) {
                bw.write(task.toFileFormat());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            throw new ClovisException("Error saving file: " + e.getMessage());
        }
    }
}