package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ArgumentsSource;

public class TaskTest {

    @Test
    public void simpleTaskQuery() {
        SimpleTask simpleTask = new SimpleTask(1, "Сходить за молоком");

        boolean expected = true;
        boolean actual = simpleTask.matches("Сходить за молоком");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void simpleTaskWrongQuery() {
        SimpleTask simpleTask = new SimpleTask(1, "Сходить за молоком");

        boolean expected = false;
        boolean actual = simpleTask.matches("Погулять с собакой");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void MeetingComplexQuery() { //проверка поискового запроса в Meeting
        Meeting meeting = new Meeting(10,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        Assertions.assertTrue(meeting.matches("Выкатка 3й версии приложения"));
        Assertions.assertTrue(meeting.matches("Приложение НетоБанка"));
        Assertions.assertFalse(meeting.matches("В пятницу вечером после работы"));
    }

    @Test
    public void EpicComplexQuery() { //проверка поискового запроса в Meeting
        String[] subtasks = {"Проверить счета", "Пойти гулять", "Выпить чаю"};
        Epic epic = new Epic(146, subtasks);

        Assertions.assertTrue(epic.matches("Проверить счета"));
        Assertions.assertFalse(epic.matches("Выпить кофе"));
    }
}

