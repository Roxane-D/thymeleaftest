package com.example.thymeleaftest.model;

public class Player {

    private int id;
    private String name;
    private String type;

    /*
     * CONSTRUCTORS
     */
    public Player() {
    }

    public Player(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Player(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

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
