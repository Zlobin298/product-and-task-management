package test.task3j;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Product {
    private String[] id;
    private String[] name;
    private double[] price;
    private int[] quantity;

    private static int expectedElementsPerArray;

    protected static String[] staticId;
    protected static String[] staticName;
    protected static double[] staticPrice;
    protected static int[] staticQuantity;

    protected static int sizeArray;

    protected static HashMap<String, List<Object>> hashMap = new HashMap<>();

    public Product() {}

    public Product(String[] id, String[] name, double[] price, int[] quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;

        sizeArray = id.length;
        staticId = id;
        staticName = name;
        staticPrice = price;
        staticQuantity = quantity;

        for (int i = 0; i < sizeArray; i++) {
            List<Object> list = new ArrayList<>();
            list.add(name[i]);
            list.add(price[i]);
            list.add(quantity[i]);

            hashMap.put(id[i], list);
        }
    }

    public String[] getName() {
        return name;
    }

    public String[] getId() {
        return id;
    }

    public double[] getPrice() {
        return price;
    }

    public int[] getQuantity() {
        return quantity;
    }

    public void setQuantity(int[] quantity) {
        this.quantity = quantity;
    }

    public static void table(int num) {
        expectedElementsPerArray = num;
        int numSourceArrays = 4;
        int numRowsInMerged = expectedElementsPerArray;
        int numColsInMerged = numSourceArrays;

        if (staticId.length != expectedElementsPerArray ||
                staticName.length != expectedElementsPerArray ||
                staticPrice.length != expectedElementsPerArray ||
                staticQuantity.length != expectedElementsPerArray) {

            System.err.println("Ошибка: Каждый из исходных массивов должен содержать ровно " + expectedElementsPerArray + " элементов");
        }

        JFrame frame = new JFrame();

        frame.setTitle("Продукты");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Object[][] data = new Object[numRowsInMerged][numColsInMerged];

        for (int i = 0; i < numRowsInMerged; i++) {
            data[i][0] = staticId[i];
            data[i][1] = staticName[i];
            data[i][2] = staticPrice[i];
            data[i][3] = staticQuantity[i];
        }

        String[] columName = {"id", "name", "price", "quantity"};

        JTable table = new JTable(data, columName);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);
        frame.setSize(500, 400);
        frame.setVisible(true);
    }

    @Override
    public String toString() {
        String format = String.format("Product{\n\tid: %s\n\tname: %s\n\tprice: %s\n\tquantity: %s\n}",
                Arrays.toString(id), Arrays.toString(name), Arrays.toString(price), Arrays.toString(quantity));

        return format;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Product product = (Product) obj;
        return Arrays.equals(this.id, product.id);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(id);
    }
}
