package by.epam.lab.util;

import by.epam.lab.bean.PriceDiscountPurchase;
import by.epam.lab.bean.Purchase;
import by.epam.lab.exception.BynValueException;
import by.epam.lab.exception.PurchaseException;

import java.util.Optional;
import java.util.Scanner;

public class PurchaseFactory {
    private static final int THREE = 3;
    private static final int FOUR = 4;

    private enum TypePurchase {
        GENERAL_PURCHASE {
            protected Purchase createInstanceOfPurchase(String[] args) {
                return new Purchase(args);
            }
        },
        DISCOUNT_PURCHASE {
            protected Purchase createInstanceOfPurchase(String[] args) {
                return new PriceDiscountPurchase(args);
            }
        };

        abstract protected Purchase createInstanceOfPurchase(String[] args);

    }

    public static Optional<Purchase> getPurchase(String csvLine) {
        Scanner scanner = new Scanner(csvLine);
        String line = scanner.next();
        String[] args = line.split(";");
        Purchase purchase = null;
        try {
            if (args.length == THREE) {
                purchase = TypePurchase.GENERAL_PURCHASE.createInstanceOfPurchase(args);
            } else if (args.length == FOUR) {
                purchase = TypePurchase.DISCOUNT_PURCHASE.createInstanceOfPurchase(args);
            }
            return Optional.ofNullable(purchase);
        } catch (BynValueException | PurchaseException | ArrayIndexOutOfBoundsException e) {
            System.err.println(csvLine);
            return Optional.empty();
        }
    }

}