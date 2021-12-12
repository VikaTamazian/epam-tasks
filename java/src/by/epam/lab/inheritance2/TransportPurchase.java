package by.epam.lab.inheritance2;

public class TransportPurchase extends UnitDiscountPurchase {
    private Byn transportCost;

    public TransportPurchase() {

    }

    public TransportPurchase(Product product, int quantity, Byn discount, Byn transportCost) {
        super(product, quantity, discount);
        this.transportCost = transportCost;
    }

    @Override
    public Byn getFinalCost(Byn baseCost) {
        return super.getFinalCost(baseCost).add(transportCost);
    }

    @Override
    public String fieldsToString() {
        return super.fieldsToString() + ";" + transportCost;
    }
}
