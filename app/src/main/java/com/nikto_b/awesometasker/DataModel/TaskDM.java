package com.nikto_b.awesometasker.DataModel;

public class TaskDM {
    private String title, left;
    private int id;

    public TaskDM(String title, String left, int id) {
        this.title  = title;
        this.left   = left;
        this.id     = id;
    }

    public String getTitle() {
        return title;
    }

    public String getLeft() {
        return left;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "TaskDM{" +
                "title='" + title + '\'' +
                ", left='" + left + '\'' +
                ", id=" + id +
                '}';
    }
}
