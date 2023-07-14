package ru.netology.manager;

public class Epic extends Task {
    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id); // вызов родительского конструктора
        this.subtasks = subtasks; // заполнение своих полей
    }

    @Override
    public boolean matches(String query) {
        for (int i = 0; i < subtasks.length; i++) {
            if (subtasks[i].contains(query)) {
                return true;
            }
        }
        return false;
    }

    public String[] getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(String[] subtasks) {
        this.subtasks = subtasks;
    }
}


