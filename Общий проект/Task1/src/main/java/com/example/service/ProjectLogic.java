package com.example.service;

import com.example.controller.Product;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProjectLogic {
    public void start() {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Настройка продукта ---");
        System.out.print("Введите название продукта: ");
        String productName = sc.nextLine();

        int initialQuantity = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Введите начальное количество продукта: ");
            try {
                initialQuantity = sc.nextInt();
                if (initialQuantity < 0) {
                    System.err.println("ОШИБКА: Количество не может быть отрицательным. Попробуйте снова.");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.err.println("ОШИБКА: Введите числовое значение. Попробуйте снова.");
                sc.next();
            }
            sc.nextLine();
        }

        Product product = new Product(productName, initialQuantity);
        System.out.println("Продукт '" + product.getName() + "' создан с начальным количеством: " + product.getQuantity());

        while (true) {
            System.out.println("\n--- Управление запасами '" + product.getName() + "' ---");
            System.out.println("1. Добавить количество");
            System.out.println("2. Убрать количество");
            System.out.println("3. Показать текущее количество");
            System.out.println("4. Выход");
            System.out.print("Выберите действие (1-4): ");

            int choice = -1;
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("ОШИБКА: Введите число от 1 до 4.");
                sc.next();
                continue;
            } finally {
                sc.nextLine();
            }

            if (choice == 4) {
                System.out.println("До свидания!");
                break;
            }

            int amount = 0;
            if (choice == 1 || choice == 2) {
                System.out.print("Введите количество: ");
                try {
                    amount = sc.nextInt();
                    sc.nextLine();
                    if (amount < 0) {
                        System.err.println("ОШИБКА: Количество не может быть отрицательным.");
                        continue;
                    }
                } catch (InputMismatchException e) {
                    System.err.println("ОШИБКА: Количество должно быть числом.");
                    sc.next();
                    continue;
                }
            }

            switch (choice) {
                case 1:
                    product.addQuantity(amount);
                    System.out.println("Добавлено " + amount + " к '" + product.getName() + "'. Новое количество: " + product.getQuantity());
                    break;

                case 2:
                    if (product.removeQuantity(amount)) {
                        System.out.println("Убрано " + amount + " из '" + product.getName() + "'. Новое количество: " + product.getQuantity());
                    } else {
                        System.err.println("ОШИБКА: Недостаточно '" + product.getName() + "' на складе. Доступно: " + product.getQuantity());
                    }
                    break;

                case 3:
                    System.out.println("Текущее количество '" + product.getName() + "': " + product.getQuantity());
                    break;

                default:
                    System.err.println("ОШИБКА: Укажите число в диапазоне от 1 до 4.");
                    break;
            }
        }
        sc.close();
    }
}
