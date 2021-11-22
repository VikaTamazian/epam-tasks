package by.gsu.epamlab.task3;

public class Purchase implements Comparable<Purchase> {
    public static final String NAME = "Bicycle";
    public static final int PRICE = 100000;
    private int quantity;
    private int discount;
    private WeekDay weekDay;

    public Purchase(int quantity, int discount, WeekDay weekDay) {
        this.quantity = quantity;
        this.discount = discount;
        this.weekDay = weekDay;
    }

    public Purchase() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }

    public int getCost() {
        return (PRICE * quantity * (100 - discount) / 100);
    }

    @Override
    public String toString() {
        return String.format("%d;%d;%s;%.2f", quantity, discount, weekDay, (double) getCost() / 100.00);

    }

    @Override
    public int compareTo(Purchase o) {
        return (quantity - o.quantity);
    }
}
