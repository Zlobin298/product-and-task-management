package com.example.service;

import com.example.controller.Status;
import com.example.controller.Task;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TaskManager {
    @Getter
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
        sortTasks();
    }

    public void changeStatus(String name, Status newStatus) {
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.getName().equals(name)) {
                Task updatedTask = new Task(task.getName(), task.getDescription(), task.getPriority(), newStatus);

                tasks.set(i, updatedTask);
                sortTasks();

                System.out.printf("Статус задачи \"%s\" изменен на ", name + newStatus);

                return;
            }
        }
        System.err.printf("Ошибка: Задача \"%s\" не найдена.", name);
    }

    public void removeTask(String name) {
        boolean removed = tasks.removeIf(task -> task.getName().equals(name));
        if (removed) {
            sortTasks();
            System.out.println("Задача \"" + name + "\" удалена.");
        } else {
            System.err.println("Ошибка: Задача \"" + name + "\" не найдена.");
        }
    }

    public void sortTasks() {
        Collections.sort(tasks, Comparator.comparingInt(Task::getPriority)
                .thenComparing(Task::getName));
    }
}

