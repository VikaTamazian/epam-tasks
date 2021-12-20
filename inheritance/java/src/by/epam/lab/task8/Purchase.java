package by.epam.lab.task8;

public class Purchase<E extends Priceable> implements Comparable<Purchase<E>> {
    private E item;
    private Number quantity;

    public E getItem() {
        return item;
    }

    public Purchase() {

    }

    public Purchase(E item, Number quantity) {
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
