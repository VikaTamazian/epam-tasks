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
    protected Byn getFinalCost(Byn baseCost) {
        if (getQuantity() >= BULK) {
            baseCost = baseCost.mul(((100 - costDiscount) / 100.0), RoundMethod.ROUND, 0);
        }
        return baseCost;

    }

    @Override
    public String fieldsToString() {
        return super.fieldsToString() + ";" + costDiscount;
    }

}
