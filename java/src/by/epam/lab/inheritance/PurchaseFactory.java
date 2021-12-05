package by.epam.lab.inheritance;

import java.util.Scanner;

public class PurchaseFactory {

    public static Purchase createPurchaseFromFactory(String type, Scanner scanner) {
        TypePurchase typePurchase = TypePurchase.valueOf(type);
        if (typePurchase == TypePurchase.GENERAL_PURCHASE) {
            return new Purchase(scanner);
        } else if (typePurchase == TypePurchase.DISCOUNT_PURCHASE) {
            return new DiscountPurchase(scanner);
        } else if (typePurchase == TypePurchase.QUANTITY_DISCOUNT_PURCHASE) {
            return new QuantityDiscountPurchase(scanner);
        }
        throw new EnumConstantNotPresentException(TypePurchase.class, typePurchase.name());
    }

}
