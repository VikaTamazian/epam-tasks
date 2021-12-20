package by.epam.lab;

public class Product implements Priceable {
    private String name;
    private Byn price;

    public Product() {
    }

    public Product(String name, Byn price) {
        this.name = name;
        this.price = price;
    }

    public Product(String name, int price) {
        this(name, new Byn(price));
    }

    public String getName() {
        return name;
    }

    public Byn getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return fieldsToString() + ";" + getPrice();
    }

    protected String fieldsToString() {
        return name;
    }
}
