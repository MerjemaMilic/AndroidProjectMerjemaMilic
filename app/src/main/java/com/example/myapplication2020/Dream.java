package com.example.myapplication2020;

public class Dream {
    public String title;
    public String description;
    public String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /* public Dream() {

    } */


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

    /*public Dream(String title, String description, String id) {
        this.title = title;
        this.description = description;
        this.id = id;
    } */
}
