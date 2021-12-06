package by.epam.lab.inheritance;

import java.util.Scanner;

public class DiscountPurchase extends Purchase {

    private double discountSmall = 0.1;

    public DiscountPurchase() {
    }

    public DiscountPurchase(String name, Byn price, int quantity, double discountSmall) {
        super(name, price, quantity);
        this.discountSmall = discountSmall;
    }

    public DiscountPurchase(Scanner scanner) {
        super(scanner);
    }

    public double getDiscountSmall() {
        return discountSmall;
    }

    public void setDiscountSmall(double discountSmall) {
        this.discountSmall = discountSmall;
    }

    @Override
    public double getCost() {
        return super.getCost() - super.getCost() * getDiscountSmall();
    }

}
