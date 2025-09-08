package test.task3j;

import javax.swing.*;
import java.util.*;

public class InventoryManager extends Product {
    private InventoryManager() {}

    public static void addProduct(Product product) {
        assert product.getId() == null : "Поле id не может быть пустым";

        try {
            for (int i = 0; i < sizeArray; i++) {
                List<Object> list = new ArrayList<>();
                list.add(product.getName()[i]);
                list.add(product.getPrice()[i]);
                list.add(product.getQuantity()[i]);

                hashMap.put(product.getId()[i], list);
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Товар с таким ID уже существует");
        }
    }

    public static void updateQuantity(String productId, int newQuantity) throws IllegalArgumentException {
        hashMap.get(productId).set(2, newQuantity);
    }

    public static List<Object> getProductById(String productId) {
        return hashMap.get(productId);
    }

    public static void removeProduct(String productId) {
        hashMap.remove(productId);
    }

    public static void getAllProducts() {
        List<Object> list = new ArrayList<>();

        Iterator<Map.Entry<String, List<Object>>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<Object>> entry = iterator.next();
            list.add(entry.getValue());
        }

        JFrame frame = new JFrame();

        frame.setTitle("Продукты");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Object[][] data = new Object[list.size()][3];

        for (int i = 0; i < list.size(); i++) {
            data[i][0] = staticName[i];
            data[i][1] = staticPrice[i];
            data[i][2] = staticQuantity[i];
        }

        String[] columName = {"name", "price", "quantity"};

        JTable table = new JTable(data, columName);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);
        frame.setSize(500, 400);
        frame.setVisible(true);
    }

    public static void displayInventory(int num) {
        table(num);
    }
}

class ProductNotFoundException extends Exception {
    public ProductNotFoundException() {
        System.err.println("Имя не найдено");
    }
}
