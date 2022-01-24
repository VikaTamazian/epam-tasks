package by.epam.lab.bean;

public class PriceDiscountPurchase extends Purchase {

    private final Byn discount;


    public PriceDiscountPurchase(String name, Byn price, int quantity, Byn discount) {
        super(name, price, quantity);
        if (discount.compareTo(price) >= 0) {
            throw new IllegalArgumentException();
        }
        this.discount = discount;
    }

    public PriceDiscountPurchase(String[] args) {
        this(args[0], new Byn(Integer.parseInt(args[1])), Integer.parseInt(args[2]),
                new Byn(Integer.parseInt(args[3])));
    }


    public Byn getDiscount() {
        return discount;
    }


    @Override
    public Byn getCost() {
        return super.getCost().sub(discount.mul(getQuantity()));
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + discount;
    }

}
