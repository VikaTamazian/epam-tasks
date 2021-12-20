package by.epam.lab;

public class Runner {
    public static void main(String[] args) {
        Purchase p1 = new Purchase(new Product("milk", 170), 20);
        PurchaseUtils pu1 = new PurchaseUtils(p1);
        pu1.printPurchase();
        pu1.printCost();

        Purchase p2 = new Purchase(new Product("sugar", 300), 12.5);
        PurchaseUtils pu2 = new PurchaseUtils(p2);
        pu2.printCost();
        pu2.printCostDiff(p1);

        Purchase p3 = new Purchase(new DiscountProduct("sugar", 280, 10), 60);

        Service gym = new Service("gym", new Byn(7560), 5);
        PurchaseUtils pu4 = new PurchaseUtils(gym, 2.25);

        Priceable item = pu4.getPurchase().getItem();
        System.out.println(item);

        pu4.printCost();

        pu2.printIsSameCost(p1, p3, pu4.getPurchase());

    }
}
