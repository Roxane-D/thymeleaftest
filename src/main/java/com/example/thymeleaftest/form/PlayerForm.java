package com.example.thymeleaftest.form;

import java.util.UUID;

public class PlayerForm {

    private UUID id;
    private String name;
    private String type;

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
