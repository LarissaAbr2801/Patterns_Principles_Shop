package shop.catalog;

import java.util.HashMap;
import java.util.Map;

public class ShopCatalog implements Catalog {

    private static ShopCatalog instance;
    private HashMap<Product, Integer> products;
    private final int minQuantity = 1; //принцип избегания магических чисел

    public ShopCatalog() {
        this.products = new HashMap<>();
    }

    public static ShopCatalog getInstance() {
        if (instance == null) instance = new ShopCatalog();
        return instance;
    }

    @Override
    public void putProduct(Product product, Integer quantity) {
        if (quantity >= minQuantity) {
            this.products.put(product, quantity);
        } else {
            System.out.println("Продукт должен быть в количестве от 1!");
        }
    }

    @Override
    public HashMap<Product, Integer> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            Integer quantity = entry.getValue();
            builder.append("\n" + product + ", количество: " + quantity + ";");
        }
        return "Каталог товаров: " + builder;
    }
}
