package by.epam.lab.inheritance2;

public class QuantityDiscountPurchase extends AbstractPurchase {
    private static final int BULK = 15;
    private double costDiscount;

    public QuantityDiscountPurchase() {
    }

    public QuantityDiscountPurchase(Product product, int quantity, double costDiscount) {
        super(product, quantity);
        this.costDiscount = costDiscount;
    }

    public double getCostDiscount() {
        return costDiscount;
    }

    public void setCostDiscount(double costDiscount) {
        this.costDiscount = costDiscount;
    }

    @Override
    public Byn getCost() {
        Byn cost = super.getCost();
        if (getQuantity() >= BULK) {
            cost = cost.mul(1.0 - costDiscount / 100, RoundMethod.FLOOR, 0);
        }
        return cost;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + costDiscount;
    }

}
