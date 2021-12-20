package by.epam.lab;

public class Purchase implements Comparable<Purchase> {
    private Priceable item;
    private Number quantity;

    public Priceable getItem() {
        return item;
    }

    public Purchase() {

    }

    public Purchase(Priceable item, Number quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Byn getCost() {
        return item.getPrice().mul(quantity.doubleValue(), RoundMethod.ROUND, 0);
    }

    @Override
    public String toString() {
        return item + ";" + quantity + ";" + getCost();
    }

    @Override
    public int compareTo(Purchase o) {
        return getCost().compareTo(o.getCost());
    }
}
