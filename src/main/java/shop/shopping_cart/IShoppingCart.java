package shop.shopping_cart;

import shop.catalog.ICatalog;
import shop.catalog.Product;
import shop.delivery.IDelivery;

public interface IShoppingCart {

    void addProduct(ICatalog catalog, Product product);
    void returnProduct(IDelivery deliver, Product product);

}
