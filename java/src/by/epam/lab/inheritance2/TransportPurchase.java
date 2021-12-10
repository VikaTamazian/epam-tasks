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
    public Byn getCost() {
        Byn byn = new Byn(super.getCost());
        byn.add(transportCost);
        return byn;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + transportCost;
    }
}
