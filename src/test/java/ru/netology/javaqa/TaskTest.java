package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void shouldMatchesSimpleTaskQueryFound() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean expected = true;
        boolean actual = simpleTask.matches(("родителям"));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesSimpleTaskQueryNotFound() {
        SimpleTask simpleTask = new SimpleTask(6, "Позвонить маме");

        boolean expected = false;
        boolean actual = simpleTask.matches(("родителям"));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesEpicQueryFound() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean expected = true;
        boolean actual = epic.matches(("Хлеб"));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesEpicQueryNotFound() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(56, subtasks);

        boolean expected = false;
        boolean actual = epic.matches(("Картошка"));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesMeetingQueryFoundProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches(("НетоБанка"));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesMeetingQueryFoundTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches(("приложения"));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesMeetingQueryNotFound() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = false;
        boolean actual = meeting.matches(("4й версии"));

        Assertions.assertEquals(expected, actual);
    }
}
