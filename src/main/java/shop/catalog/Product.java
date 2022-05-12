package shop.catalog;

import java.util.Objects;

public class Product {

    public enum SpecificProduct {
        MILK ("Молоко"),
        BREAD ("Хлеб"),
        CHEESE ("Сыр"),
        TEA ("Чай"),
        COFFEE ("Кофе");

        private final String title;

        SpecificProduct(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }

    private SpecificProduct name;
    private int price;
    private String brand;

    public Product(SpecificProduct name, int price, String brand) {
        this.name = name;
        this.price = price;
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name.title;
    }

    public void setName(SpecificProduct name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && price == product.price &&
                Objects.equals(brand, product.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, brand);
    }

    @Override
    public String toString() {
        return "наименование товара = " + name.title +
                ", цена = " + price +
                ", производитель = " + "'"+ brand + "'";
    }
}
