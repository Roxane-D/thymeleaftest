package com.example.thymeleaftest.form;

public class PlayerForm {

    private int id;
    private String name;
    private String type;

    /*
     * GETTERS
     */

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    /*
     * SETTERS
     */
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
}
