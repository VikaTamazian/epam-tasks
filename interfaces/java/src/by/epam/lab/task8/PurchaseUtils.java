package by.epam.lab.task8;

public class PurchaseUtils<E extends Priceable> {
    private Purchase<E> purchase;

    public PurchaseUtils(Purchase<E> purchase) {
        this.purchase = purchase;
    }

    public PurchaseUtils(E item, Number quantity) {
        this.purchase = new Purchase<E>(item, quantity);
    }

    public Purchase<E> getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase<E> purchase) {
        this.purchase = purchase;
    }

    public void printPurchase() {
        System.out.println(purchase);
    }

    public void printCost() {
        System.out.println(purchase.getCost());
    }

    public void printCostDiff(Purchase<E> p) {
        String message = null;
        Byn costDiff = new Byn();
        int value = purchase.compareTo(p);
        if (value > 0) {
            message = "positive number";
            costDiff = purchase.getCost().sub(p.getCost());
        } else if (value < 0) {
            message = "negative number";
            costDiff = p.getCost().sub(purchase.getCost());
        }
        System.out.println(message + " is " + costDiff);


    }

    @SafeVarargs
    public final <T extends Priceable> void printIsSameCost(Purchase<?>... purchases) {

        boolean flag = false;
        for (Purchase<?> p : purchases) {
            if (purchase.equals(p)) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println(purchase);
        } else {
            System.out.println("Not found");
        }
    }
}

