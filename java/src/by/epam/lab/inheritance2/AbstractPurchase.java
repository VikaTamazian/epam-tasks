package by.epam.lab.inheritance2;

import java.util.Objects;

public abstract class AbstractPurchase implements Comparable<AbstractPurchase> {
    private final Product product;
    private int quantity;

    public AbstractPurchase() {
        product = new Product();
    }

    public AbstractPurchase(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    protected abstract Byn getFinalCost(Byn baseCost);

    public Byn getCost() {
        Byn baseCost = product.getPrice().mul(quantity);
        Byn finalCost = getFinalCost(baseCost);
        return finalCost.round(RoundMethod.FLOOR, 2);
    }


    @Override
    public String toString() {
        return fieldsToString() + ";" + getCost();
    }

    protected String fieldsToString() {
        return String.format("%s;%d", product, quantity);
    }

    public int compareTo(AbstractPurchase o) {

        return getCost().compareTo(o.getCost());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractPurchase that = (AbstractPurchase) o;
        return quantity == that.quantity && Objects.equals(product, that.product);
    }

}
