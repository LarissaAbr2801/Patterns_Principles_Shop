package shop.delivery;

import shop.catalog.Product;

public interface Delivery {

    String deliver(Product product);
    String refund(Product product);
}
