package by.epam.lab.inheritance;

import java.util.Scanner;

import static by.epam.lab.inheritance.DiscountPurchase.DISCOUNT_SMALL;

public class QuantityDiscountPurchase extends Purchase {
    private static final double DISCOUNT_LARGE = 0.35;
    private static final int BULK_ORDER = 10;

    public QuantityDiscountPurchase() {
    }

    public QuantityDiscountPurchase(Scanner scanner) {
        super(scanner);
    }

    @Override
    public double getCost() {
        if (quantity >= BULK_ORDER) {
            return super.getCost() - super.getCost() * DISCOUNT_LARGE;
        } else {
            return super.getCost() - super.getCost() * DISCOUNT_SMALL;
        }
    }

}
