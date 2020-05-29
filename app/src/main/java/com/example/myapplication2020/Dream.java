package com.example.myapplication2020;

public class Dream {
    private String title;
    private String description;

    public Dream() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Dream(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
