package clovis.task;

import clovis.ClovisException;

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
     * Adds a task to the list after checking if the specified task is a duplicate.
     *
     * @param task the task to be added.
     */
    public void addTask(Task task) throws ClovisException {
        if (containsTask(task)) {
            throw new ClovisException("This task already exists in your list");
        }
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
     * Checks all the tasks in the list to search for tasks that contains the matching keyword.
     *
     * @param keyword the keyword used to search for matching tasks.
     * @return the {@code ArrayList} of tasks that contains the specified keyword.
     */
    public ArrayList<Task> findTask(String keyword) {
        ArrayList<Task> matchingTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.description.toLowerCase().contains(keyword.toLowerCase())) {
                matchingTasks.add(task);
            }
        }
        return matchingTasks;
    }

    /**
     * Checks if the specified task  already exists in the task list.
     *
     * @param task the task to be checked.
     * @return {@code True} if the specified task exists in the list,
     * else {@code False} if it does not exist in the list.
     */
    public boolean containsTask(Task task) {
        for (Task taskInList : tasks) {
            if (taskInList.description.equalsIgnoreCase(task.description))
                return true;
        }
        return false;
    }
}
