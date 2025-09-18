package com.example.controller;

public class Product {
    private String name;
    private int quantity;

    public Product(String name, int initialQuantity) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название товара не может быть пустым.");
        }
        if (initialQuantity < 0) {
            throw new IllegalArgumentException("Начальное количество товара не может быть отрицательным.");
        }
        this.name = name;
        this.quantity = initialQuantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Количество для добавления не может быть отрицательным.");
        }
        this.quantity += amount;
    }

    public boolean removeQuantity(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Количество для удаления не может быть отрицательным.");
        }
        if (this.quantity - amount < 0) {
            return false;
        }
        this.quantity -= amount;
        return true;
    }

    @Override
    public String toString() {
        return "Продукт: " + name + ", Количество: " + quantity;
    }
}
