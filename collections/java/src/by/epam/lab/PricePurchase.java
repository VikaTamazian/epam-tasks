package by.epam.lab;

public class PricePurchase extends Purchase {

    private Byn discount;

    public PricePurchase() {
    }

    public PricePurchase(String name, Byn price, int quantity, Byn discountSmall) {
        super(name, price, quantity);
        this.discount = discountSmall;
    }

//    public PricePurchase(Scanner scanner) {
//        super(scanner);
//        setDiscount(new Byn(Integer.parseInt(scanner.next())));
//    }

    public PricePurchase(String name, String price, String quantity, String discount) {
        super(name, price, quantity);
        setDiscount(new Byn(Integer.parseInt(discount)));
    }

    public Byn getDiscount() {
        return discount;
    }

    public void setDiscount(Byn discount) {
        this.discount = discount;
    }

    @Override
    public Byn getCost() {
        return super.getPrice().sub(discount);
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + discount;
    }

}
