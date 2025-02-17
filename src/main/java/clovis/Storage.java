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
import java.io.IOException;

import java.util.ArrayList;

public class Storage {
    private final String filePath;

    public Storage (String filePath) {
        this.filePath = filePath;
    }
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
                String[] input = line.split(" \\| ");
                String taskType = input[0];
                boolean isDone = input[1].equals("1");
                String taskDescription = input[2];

                switch (taskType) {
                    case "T":
                        tasks.add(new ToDo(taskDescription, isDone));
                        break;
                    case "D":
                        tasks.add(new Deadline(taskDescription, isDone, input[3]));
                        break;
                    case "E":
                        tasks.add(new Event(taskDescription, isDone, input[3], input[4]));
                    default:
                        System.out.println("Unknown task type: " + taskType);
                }
            }
        } catch (IOException e) {
            throw new ClovisException("Error loading file: " + e.getMessage());
        }
        return tasks;
    }

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