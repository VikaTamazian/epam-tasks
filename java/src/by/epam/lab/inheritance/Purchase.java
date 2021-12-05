package by.epam.lab.inheritance;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Scanner;

public class Purchase implements Comparable<Purchase> {
    private String name;
    private Byn price;
    protected int quantity;
    private TypePurchase typePurchase;

    public Purchase() {
    }

    public Purchase(String name, Byn price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Purchase(Scanner scanner) {
        this.name = scanner.next();
        this.price.kopeck = scanner.nextInt();
        this.quantity = scanner.nextInt();
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return price.kopeck * quantity / 100.00;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return price == purchase.price && Objects.equals(name, purchase.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%d;%.2f", name, price, quantity, getCost());
    }


    @Override
    public int compareTo(@NotNull Purchase o) {
        return price.kopeck - o.getPrice().kopeck;
    }
}
