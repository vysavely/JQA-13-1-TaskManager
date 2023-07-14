package ru.netology.manager;

public class Meeting extends Task {
    protected String topic;
    protected String project;
    protected String start;


    public Meeting(int id, String topic, String project, String start) {
        super(id); // вызов родительского конструктора

        this.topic = topic; // заполнение своих полей
        this.project = project;
        this.start = start;
    }

    @Override
    public boolean matches(String query) {
        if (topic.contains(query)) {
            return true;
        }
        if (project.contains(query)) {
            return true;
        }
        return false;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }
}
