import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;

public class Storage {
    private static final String FILE_PATH = "data/tasks.txt";

    public static ArrayList<Task> loadTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(FILE_PATH);

        if(!file.exists()) {
            return tasks;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
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
            System.out.println("Error reading file: " + FILE_PATH);
        }
        return tasks;
    }

    public static void saveTasks(ArrayList<Task> tasks) {
        try {
            File file = new File(FILE_PATH);
            file.getParentFile().mkdirs();

            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (Task task : tasks) {
                bw.write(task.toFileFormat());
                bw.newLine();   
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Error saving file: " + FILE_PATH);
        }
    }
}