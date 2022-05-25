package shop.shopping_cart;

import shop.catalog.Catalog;
import shop.catalog.Product;
import shop.delivery.Delivery;

public interface ShoppingCart {

    void addProduct(Catalog catalog, Product product);
    void returnProduct(Delivery deliver, Product product);

}
