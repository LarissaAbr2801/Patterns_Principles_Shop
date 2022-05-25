import shop.catalog.ShopCatalog;
import shop.catalog.Product;
import shop.delivery.Delivery;
import shop.delivery.ShopDelivery;
import shop.shopping_cart.ShoppingCart;
import shop.shopping_cart.ProductsShoppingCart;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Product bread = new Product(Product.SpecificProduct.BREAD, 20, "Хлебопекарня");
        Product cheese = new Product(Product.SpecificProduct.CHEESE, 100, "Сыроварня");

        ShopCatalog catalog = ShopCatalog.getInstance();
        catalog.putProduct(bread, 4);

        ShoppingCart shoppingCart = new ProductsShoppingCart(); //Dependency inversion principle

        shoppingCart.addProduct(catalog, bread); //DRY
        shoppingCart.addProduct(catalog, cheese); //DRY
        shoppingCart.addProduct(catalog, bread); //DRY


        Delivery delivery = new ShopDelivery(); //Single-Responsibility principle:
        // класс отвечает только за доставку товаров магазина
        // + Dependency inversion principle
        shoppingCart.returnProduct(delivery, bread);

        List<Product> recommendations =
                ((ProductsShoppingCart) shoppingCart).recommend(catalog, "Хлебопекарня");
        // Open-Closed principle : новый метод добавлен в имплементацию интерфейса,
        // сам интерфейс остался неизменым.

        if (recommendations.isEmpty()) {
            System.out.println("Производитель не найден!");
        } else {
            System.out.println("Рекомендации для покупателя: ");
            recommendations.forEach(System.out::println);
        }


        System.out.println();
        System.out.println(catalog);
        System.out.println(shoppingCart);
    }
}
