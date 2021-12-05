package by.epam.lab.inheritance;

import java.util.Scanner;

public class DiscountPurchase extends Purchase {

    public static final double DISCOUNT_SMALL = 0.1;

    public DiscountPurchase() {
    }

    public DiscountPurchase(Scanner scanner) {
        super(scanner);
    }

    @Override
    public double getCost() {
        return super.getCost() - super.getCost() * DISCOUNT_SMALL;
    }

}
