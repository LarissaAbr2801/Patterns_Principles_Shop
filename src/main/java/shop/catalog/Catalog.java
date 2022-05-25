package shop.catalog;

import java.util.HashMap;

public interface Catalog {

    void putProduct(Product product, Integer quantity);
    HashMap<Product, Integer> getProducts();
}
