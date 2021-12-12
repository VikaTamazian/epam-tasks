package by.epam.lab.inheritance2;

public class UnitDiscountPurchase extends AbstractPurchase {
    private Byn unitDiscount;

    public UnitDiscountPurchase() {
    }

    public UnitDiscountPurchase(Product product, int quantity, Byn discount) {
        super(product, quantity);
        this.unitDiscount = discount;
    }

    public Byn getUnitDiscount() {
        return unitDiscount;
    }

    public void setUnitDiscount(Byn unitDiscount) {
        this.unitDiscount = unitDiscount;
    }

    @Override
    public Byn getFinalCost(Byn baseCost) {
        return baseCost.sub(unitDiscount.mul(getQuantity()));

    }

    @Override
    public String fieldsToString() {
        return super.fieldsToString() + ";" + unitDiscount;
    }


}
