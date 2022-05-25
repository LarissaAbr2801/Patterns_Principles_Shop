package shop.delivery;

import shop.catalog.Product;

public class ShopDelivery implements Delivery {

    @Override
    public String deliver(Product product) {
        return "Заказ успешно доставлен!";
    }

    @Override
    public String refund(Product product) {
        return "Возврат товара прошел успешно!";
    }
}
