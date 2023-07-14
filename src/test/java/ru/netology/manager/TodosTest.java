package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {


    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchSimpleTask() {
        Todos todos = new Todos();
        SimpleTask simpleTask = new SimpleTask(1, "Вымыть посуду");
        todos.add(simpleTask);
        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Вымыть посуду");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchMeeting() {
        Todos todos = new Todos();
        Meeting meeting = new Meeting(11,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");
        todos.add(meeting);
        Task[] expected = {meeting};
        Task[] actual = todos.search("Приложение НетоБанка");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchEpic() {
        String[] subtasks = {"Проверить счета", "Пойти гулять", "Выпить чаю"};

        Todos todos = new Todos();
        Epic epic = new Epic(1, subtasks);
        todos.add(epic);
        Task[] expected = {epic};
        Task[] actual = todos.search("Пойти гулять");

        Assertions.assertArrayEquals(expected, actual);
    }
}