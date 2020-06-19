package com.nikto_b.awesometasker.DataModel;

public class TaskDM {
    private String title, left;

    public TaskDM(String title, String left) {
        this.title = title;
        this.left = left;
    }

    public String getTitle() {
        return title;
    }

    public String getLeft() {
        return left;
    }
}
