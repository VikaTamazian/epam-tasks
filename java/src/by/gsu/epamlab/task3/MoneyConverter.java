package by.gsu.epamlab.task3;

public class MoneyConverter {

    private MoneyConverter() {
    }

    public static String toConvert(int value) {
        return String.format("%d,%02d", value / 100, value % 100);
    }

    public static String toConvert(double value) {
        return String.format("%.3f", value / 100);
    }
}
