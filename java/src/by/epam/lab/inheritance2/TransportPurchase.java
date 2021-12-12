package by.epam.lab.inheritance2;

public class TransportPurchase extends AbstractPurchase {
    private Byn transportCost;

    public TransportPurchase() {

    }

    public Byn getTransportCost() {
        return transportCost;
    }

    public void setTransportCost(Byn transportCost) {
        this.transportCost = transportCost;
    }

    public TransportPurchase(Product product, int quantity, Byn transportCost) {
        super(product, quantity);
        this.transportCost = transportCost;
    }

    @Override
    public Byn getFinalCost(Byn baseCost) {
        return baseCost.add(transportCost);
    }

    @Override
    public String fieldsToString() {
        return super.fieldsToString() + ";" + transportCost;
    }
}
