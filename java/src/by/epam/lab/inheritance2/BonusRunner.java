package by.epam.lab.inheritance2;

import java.util.Arrays;

public class BonusRunner {

    //method will be upgraded

    public static void main(String[] args) {
        final Product product = new Product("candy", new Byn(50));

        AbstractPurchase[] purchases = {
                new UnitDiscountPurchase(product, 10, new Byn(0)),
                new UnitDiscountPurchase(product, 12, new Byn(10)),
                new QuantityDiscountPurchase(product, 40, 30),
                new QuantityDiscountPurchase(product, 50, 80),
                new TransportPurchase(product, 8, new Byn(100)),
                new TransportPurchase(product, 30, new Byn(200)),
        };

        toPrint(purchases);
        Arrays.sort(purchases);
        toPrint(purchases);
        System.out.printf("Minimum cost = %s\n", purchases[purchases.length - 1].getCost());
        toSearch(purchases);


    }

    private static void toPrint(AbstractPurchase[] purchases) {
        for (AbstractPurchase purchase : purchases) {
            System.out.println(purchase);
        }
        System.out.println();
    }

    private static void toSearch(AbstractPurchase[] purchases) {

        Product someProduct = new Product("some product", new Byn(500));
        AbstractPurchase purchaseToSearch = new UnitDiscountPurchase(someProduct, 1, new Byn(0));
        for (int i = 0; i <= purchases.length; i++) {
            int search = Arrays.binarySearch(purchases, purchaseToSearch);
            if (search > 0) {
                System.out.println(purchases[search]);
                purchases[search].setQuantity(100);
                toSearch(purchases);
            }
        }

    }

}
