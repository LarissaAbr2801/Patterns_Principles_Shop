package shop.shopping_cart;

import shop.catalog.Catalog;
import shop.catalog.Product;
import shop.delivery.Delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductsShoppingCart implements ShoppingCart {

    private List<Product> shoppingCart;

    public ProductsShoppingCart() {
        this.shoppingCart = new ArrayList<>();
    }

    @Override
    public void addProduct(Catalog catalog, Product product) {
        if (catalog.getProducts().containsKey(product)) {
            shoppingCart.add(product);
            System.out.println("Товар " + product.getName() + " успешно добавлен в корзину!");
        } else {
            System.out.println("Товар "+ product.getName() + " не добавлен в корзину!");
        }
    }

    @Override
    public void returnProduct(Delivery delivery, Product product) {
        if (shoppingCart.contains(product)) {
            shoppingCart.remove(product);
            delivery.refund(product);
            System.out.println("Товар будет возвращен!");
        }
    }

    public List<Product> recommend(Catalog catalog, String brand) {
        List<Product> recommendations = new ArrayList<>();

        for (Map.Entry<Product, Integer> entry : catalog.getProducts().entrySet()) {
            Product product = entry.getKey();
            if (product.getBrand().equals(brand)) {
                recommendations.add(product);
            }
        }
        return recommendations;
    }

    @Override
    public String toString() {
        return "Корзина покупателя: " + shoppingCart;
    }
}
