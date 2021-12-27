package by.epam.lab;

import java.util.Objects;
import java.util.Scanner;

public class Purchase implements Comparable<Purchase> {
    private String name;
    private Byn price;
    protected int quantity;


    public Purchase() {
    }

    public Purchase(String name, Byn price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }


    public Purchase(String name, String price, String quantity) {
        this.name = name;
        this.price = new Byn(Integer.parseInt(price));
        this.quantity = Integer.parseInt(quantity);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byn getPrice() {
        return price;
    }

    public void setPrice(Byn price) {
        this.price = price;
    }

    public Number getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Byn getCost() {
        return price.mul(quantity, RoundMethod.ROUND, 0);
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


    @Override
    public String toString() {
        return fieldsToString() + ";" + getCost();
    }

    protected String fieldsToString() {
        return getClass().getSimpleName() + ";" + name + ";" + price + ";" + quantity;
    }


    @Override
    public int compareTo(Purchase o) {
        return getCost().compareTo(o.getCost());
    }
}
