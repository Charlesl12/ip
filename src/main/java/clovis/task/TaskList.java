package clovis.task;

import java.util.ArrayList;

/**
 * The {@code TaskList} class represents a collection of tasks.
 */
public class TaskList {
    private final ArrayList<Task> tasks;

    /**
     * Constructs an empty {@code TaskList}.
     */
    public TaskList() {
        tasks = new ArrayList<>();
    }

    /**
     * Constructs a {@code TaskList} with an existing list of tasks.
     *
     * @param tasks the lists of tasks to initialize the {@code TaskList} with.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Returns the list of tasks.
     *
     * @return the {@code ArrayList} of tasks.
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Retrieve a task from the list, based on the specified index.
     *
     * @param index the index of the task (1-based index).
     * @return the task at the specified index.
     */
    public Task getTask(int index) {
        return tasks.get(index - 1);
    }

    /**
     * Adds a task to the list.
     *
     * @param task the task to be added.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Deletes a task from the list, based on the specified index.
     *
     * @param index the index of the task (1-based index).
     * @return the task at the specified index.
     */
    public Task deleteTask(int index) {
        return tasks.remove(index - 1);
    }

    /**
     * Marks a task as completed or uncompleted, based on the specified index.
     *
     * @param index the index of the task (1-based index).
     * @param isDone {@code True} to mark task as completed and {@code False} to mark task as uncompleted.
     * @return the task at the specified index with its completion status updated.
     */
    public Task markTask(int index, boolean isDone) {
        Task task = tasks.get(index - 1);
        if (isDone) {
            task.markAsDone();
        } else {
            task.markAsNotDone();
        }
        return task;
    }

    /**
     * Checks if the list is empty.
     *
     * @return {@code true} if the list is empty, {@code false} otherwise.
     */
    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    /**
     * Returns the number of tasks in the list.
     *
     * @return the size of the list.
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Displays all the tasks in the list.
     */
    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("List is empty");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    /**
     * Checks all the tasks in the list to search for tasks that contains the matching keyword.
     *
     * @param keyword the keyword used to search for matching tasks.
     * @return the {@code ArrayList} of tasks that contains the specified keyword.
     */
    public ArrayList<Task> findTask(String keyword) {
        ArrayList<Task> matchingTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.description.contains(keyword)) {
                matchingTasks.add(task);
            }
        }
        return matchingTasks;
    }
}
