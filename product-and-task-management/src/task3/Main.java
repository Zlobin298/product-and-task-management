package test.task3j;

public class Main {
    public static void main(String[] args) throws ProductNotFoundException {
        /*String[] id = {"1", "2", "3"};
        String[] name = {"Яблоко", "Банан", "Груша"};
        double[] price = {100, 100, 100};
        int[] quantity = {100, 50, 20};*/
        String[] id = {"1", "2", "3", "4"};
        String[] name = {"Яблоко", "Апельсин", "Банан", "Груша"};
        double[] price = {100, 100, 100, 100};
        int[] quantity = {100, 50, 20, 80};
        Product p = new Product(id, name, price, quantity);

//        System.out.println(p.toString());
        InventoryManager.addProduct(p);
//        InventoryManager.removeProduct("2");

        InventoryManager.getAllProducts();

        System.out.println();
        System.out.println(InventoryManager.getProductById("1"));

        InventoryManager.updateQuantity("1", 200);

        System.out.println();
        System.out.println(InventoryManager.getProductById("1"));

//        Product.table(4); // необходимо задать число элементов в массиве
    }
}
