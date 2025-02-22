package clovis.task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TaskListTest {

    @Test
    public void testAddTaskAndGetTask() {
        TaskList tasks = new TaskList();
        ToDo todo = new ToDo("read book");
        tasks.addTask(todo);

        assertEquals(1, tasks.size());
        assertEquals(todo, tasks.getTask(1));
    }

    @Test
    public void testDeleteTask() {
        TaskList tasks = new TaskList();
        ToDo todo1 = new ToDo("read book");
        ToDo todo2 = new ToDo("return book");
        tasks.addTask(todo1);
        tasks.addTask(todo2);
        Task deletedTask = tasks.deleteTask(1);

        assertEquals(todo1, deletedTask);
        assertEquals(1, tasks.size());
    }

    @Test
    public void testMarkTask() {
        TaskList tasks = new TaskList();
        ToDo todo1 = new ToDo("read book");
        ToDo todo2 = new ToDo("return book");
        tasks.addTask(todo1);
        tasks.addTask(todo2);
        tasks.markTask(1, true);
        tasks.markTask(2, false);

        assertEquals(true, todo1.isDone);
        assertEquals(false, todo2.isDone);
    }


    @Test
    public void testFindTask_returnsMatchingTask() {
        TaskList tasks = new TaskList();
        ToDo todo1 = new ToDo("read book");
        ToDo todo2 = new ToDo("return book");
        tasks.addTask(todo1);
        tasks.addTask(todo2);
        ArrayList<Task> matchingTasks = tasks.findTask("Read");

        assertEquals(1, matchingTasks.size());
        assertEquals(todo1, matchingTasks.get(0));
    }

    @Test
    public void testFindTask_returnsNoMatchingTask() {
        TaskList tasks = new TaskList();
        ToDo todo1 = new ToDo("read book");
        ToDo todo2 = new ToDo("return book");
        tasks.addTask(todo1);
        tasks.addTask(todo2);
        ArrayList<Task> matchingTasks = tasks.findTask("sLeep");

        assertEquals(1, matchingTasks.size());
        assertTrue(matchingTasks.isEmpty());
    }
}
