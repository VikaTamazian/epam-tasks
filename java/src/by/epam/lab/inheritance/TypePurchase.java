package by.epam.lab.inheritance;

import java.util.Locale;

public enum TypePurchase {
    GENERAL_PURCHASE,
    DISCOUNT_PURCHASE,
    QUANTITY_DISCOUNT_PURCHASE;

    @Override
    public String toString() {

        return name().toLowerCase(Locale.ROOT);
    }

}



