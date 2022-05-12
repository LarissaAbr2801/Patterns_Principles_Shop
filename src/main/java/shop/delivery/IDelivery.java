package shop.delivery;

import shop.catalog.Product;

public interface IDelivery {

    String deliver(Product product);
    String refund(Product product);
}
