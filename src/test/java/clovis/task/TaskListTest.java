package clovis.task;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

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
}
