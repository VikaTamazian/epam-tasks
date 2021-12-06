package by.epam.lab.inheritance;

import java.util.Scanner;

public class QuantityDiscountPurchase extends Purchase {
    private double discountLarge = 0.35;
    private static final int BULK_ORDER = 10;

    public QuantityDiscountPurchase() {
    }

    public QuantityDiscountPurchase(String name, Byn price, int quantity, double discountLarge) {
        super(name, price, quantity);
        this.discountLarge = discountLarge;
    }

    public QuantityDiscountPurchase(Scanner scanner) {
        super(scanner);
    }

    public double getDiscountLarge() {
        return discountLarge;
    }

    public void setDiscountLarge(double discountLarge) {
        this.discountLarge = discountLarge;
    }

    @Override
    public double getCost() {
        DiscountPurchase discountPurchase = new DiscountPurchase();
        double result;
        if (quantity >= BULK_ORDER) {
            result = super.getCost() - super.getCost() * getDiscountLarge();
        } else {
            result = super.getCost() - super.getCost() * discountPurchase.getDiscountSmall();
        }
        return result;
    }


}
