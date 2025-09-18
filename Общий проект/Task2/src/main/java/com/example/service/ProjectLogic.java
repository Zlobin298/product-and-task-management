package com.example.service;

import com.example.controller.Status;
import com.example.controller.Task;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProjectLogic {
    public void start() {
        TaskManager taskManager = new TaskManager();
        Scanner sc = new Scanner(System.in);

        System.out.println("Система управления задачами\n" +
                "Выберите действие:\n" +
                "1. Добавить задачу\n" +
                "2. Показать все задачи\n" +
                "3. Изменить статус задачи\n" +
                "4. Удалить задачу\n" +
                "5. Сортировать по приоритету\n" +
                "6. Выход");

        while (true) {
            System.out.print(">>> ");
            int num = -1;

            try {
                num = sc.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("ОШИБКА: Введите число от 1 до 6.");
                sc.next();
                continue;
            } finally {
                sc.nextLine();
            }

            if (num == 6) {
                System.out.println("Выход из программы.");
                break;
            }

            switch (num) {
                case 1:
                    System.out.print("Введите название задачи: ");
                    String name = sc.nextLine();

                    System.out.print("Введите описание: ");
                    String description = sc.nextLine();

                    int priority = 0;
                    boolean validPriority = false;
                    while (!validPriority) {
                        System.out.print("Введите приоритет (от 1 до 5): ");
                        try {
                            priority = sc.nextInt();
                            if (priority < 1) {
                                System.err.println("ОШИБКА: Приоритет не совпадает с диапазоном");
                            } else if (priority > 5) {
                                System.err.println("ОШИБКА: Приоритет не совпадает с диапазоном");
                            } else {
                                validPriority = true;
                            }
                        } catch (InputMismatchException e) {
                            System.err.println("ОШИБКА: Приоритет должен быть целым числом. Попробуйте снова.");
                            sc.next();
                        } finally {
                            sc.nextLine();
                        }
                    }

                    Task newTask = new Task(name, description, priority, Status.NEW);
                    taskManager.addTask(newTask);

                    System.out.printf("Задача \"%s\" добавлена.\n", name);
                    break;

                case 2:
                    System.out.println("\n--- Список всех задач ---");
                    if (taskManager.getTasks().isEmpty()) {
                        System.out.println("Список задач пуст.");
                    } else {
                        for (Task task : taskManager.getTasks()) {
                            System.out.println(task);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Укажите название задачи для изменения статуса: ");
                    String name1 = sc.nextLine();

                    System.out.print("Укажите новый статус (NEW, IN_PROGRESS или DONE): ");
                    String s = sc.nextLine().toUpperCase();
                    Status newStatus = null;

                    try {
                        newStatus = Status.valueOf(s);
                        taskManager.changeStatus(name1, newStatus);
                    } catch (IllegalArgumentException e) {
                        System.err.println("ОШИБКА: Некорректное название статуса. Задача не изменена.");
                    }
                    break;

                case 4:
                    System.out.print("Укажите название задачи для удаления: ");
                    String name2 = sc.nextLine();
                    taskManager.removeTask(name2);
                    break;

                case 5:
                    taskManager.sortTasks();
                    System.out.println("\n--- Задачи отсортированы по приоритету ---");
                    for (Task task : taskManager.getTasks()) {
                        System.out.println(task);
                    }
                    break;

                default:
                    System.err.println("ОШИБКА: Неизвестное действие. Пожалуйста, выберите число от 1 до 6.");
                    break;
            }
        }
        sc.close();
    }
}
