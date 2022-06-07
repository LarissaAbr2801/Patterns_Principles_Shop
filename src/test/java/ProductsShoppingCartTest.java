import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import shop.catalog.ShopCatalog;
import shop.catalog.Catalog;
import shop.catalog.Product;
import shop.delivery.Delivery;
import shop.shopping.cart.ProductsShoppingCart;

import java.util.List;
import java.util.stream.Stream;

public class ProductsShoppingCartTest {

    ProductsShoppingCart sut;

    @BeforeEach
    public void initEach() {
        System.out.println("Тест для метода класса ProductsShoppingCart запущен");
    }

    @AfterEach
    public void finishEach() {
        System.out.println("Тест для метода класса ProductsShoppingCart завершен");
    }

    @ParameterizedTest
    @MethodSource("sourceTestReturnProduct")
    void testReturnProduct(Product product) {
        Delivery delivery = Mockito.mock(Delivery.class);

        ArgumentCaptor<Product> captor = ArgumentCaptor.forClass(Product.class);

        ShopCatalog catalog = new ShopCatalog();
        catalog.putProduct(product, 2);

        sut = new ProductsShoppingCart();
        sut.addProduct(catalog, product);

        sut.returnProduct(delivery, product);

        Mockito.verify(delivery).refund(captor.capture());

        Assertions.assertEquals(product, captor.getValue());
    }

    private static Stream<Arguments> sourceTestReturnProduct() {
        return Stream.of(Arguments.of(new Product(Product.SpecificProduct.BREAD,
                34, "Bread")));
    }

    @ParameterizedTest
    @MethodSource("sourceTestRecommend")
    void testRecommend(ShopCatalog catalog, String brand, List<Product> expected) {
        sut = new ProductsShoppingCart();
        List<Product> result = sut.recommend(catalog, brand);
        Assertions.assertEquals(result, expected);
    }

    private static Stream<Arguments> sourceTestRecommend() {
        Catalog catalog = ShopCatalog.getInstance();
        catalog.putProduct(new Product(Product.SpecificProduct.CHEESE, 100, "DairyFarm"),
                2);
        catalog.putProduct(new Product(Product.SpecificProduct.MILK, 50, "DairyFarm"), 0);

        return Stream.of(Arguments.of(catalog, "DairyFarm",
                        List.of(new Product(Product.SpecificProduct.CHEESE, 100, "DairyFarm"))),
                Arguments.of(catalog, "cheese", List.of()));
    }
}
