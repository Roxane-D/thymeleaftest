package com.example.thymeleaftest.model;

import java.util.UUID;

public class Player {

    private UUID id;
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

    public Player(UUID id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    /*
     * GETTERS
     */
    public UUID getId() {
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
    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
}
