package com.example.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Task {
    private String name;
    private String description;
    private int priority;
    private Status status;

    public Task() {
    }

    public Task(String name, String description, int priority, Status status) {
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("["+ status +"] (%d) %s: %s", priority, name, description);
    }
}
