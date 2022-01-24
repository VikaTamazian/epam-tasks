package by.epam.lab.bean;

import by.epam.lab.exception.TypeException;
import by.epam.lab.exception.PurchaseException;

import java.util.Objects;

public class Purchase implements Comparable<Purchase> {
    private final String name;
    private final Byn price;
    private final int quantity;

    public Purchase(String name, Byn price, int quantity) {
        if (name.isEmpty()
            || name.matches("^$")
            || "".equals(name.trim())
            || price.compareTo(new Byn(0)) <= 0
            || quantity <= 0) {
            throw new PurchaseException(TypeException.ERROR_EMPTY_NAME.toString());
        }
        this.name = name;
        this.price = new Byn(price);
        this.quantity = quantity;
    }

    public Purchase(String[] args) {
        this.name = args[0];
        this.price = new Byn(args[1]);
        this.quantity = Integer.parseInt(args[2]);
    }

    public String getName() {
        return name;
    }

    public Byn getPrice() {
        return price;
    }


    public int getQuantity() {
        return quantity;
    }


    public Byn getCost() {
        return price.mul(quantity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchase purchase)) return false;
        return price == purchase.price && Objects.equals(name, purchase.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }


    protected String fieldsToString() {
        return name + ";" + price + ";" + quantity;
    }

    public String toString(Purchase t) {
        return fieldsToString() + ";" + getCost();
    }


    @Override
    public int compareTo(Purchase o) {
        int value = name.compareTo(o.name);
        if (value == 0) {
            value = price.compareTo(o.getPrice());
        }
        return value;
    }
}
