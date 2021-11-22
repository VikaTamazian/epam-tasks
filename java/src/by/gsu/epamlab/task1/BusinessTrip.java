package by.gsu.epamlab.task1;

public class BusinessTrip {

    private static final int DAILY_ALLOWANCE_RATE = 1000;
    private String employeesAccount;
    private int transportationExpenses;
    private int numberOfDays;

    public BusinessTrip(String employeesAccount, int transportationExpenses, int numberOfDays) {
        this.employeesAccount = employeesAccount;
        this.transportationExpenses = transportationExpenses;
        this.numberOfDays = numberOfDays;
    }

    public BusinessTrip() {
    }

    public String getEmployeesAccount() {
        return employeesAccount;
    }

    public void setEmployeesAccount(String employeesAccount) {
        this.employeesAccount = employeesAccount;
    }

    public int getTransportationExpenses() {
        return transportationExpenses;
    }

    public void setTransportationExpenses(int transportationExpenses) {
        this.transportationExpenses = transportationExpenses;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public int getTotal() {
        return ((transportationExpenses + DAILY_ALLOWANCE_RATE) * numberOfDays);
    }

    public void show(String employeesAccount, int transportationExpenses, int numberOfDays) {
        int total = getTotal();
        System.out.printf("rate = %s \n" +
                          "account = %s \n" +
                          "transport = %s \n" +
                          "days = %s \n" +
                          "total = %s \n",
                convertToDecimal(DAILY_ALLOWANCE_RATE), employeesAccount,
                convertToDecimal(transportationExpenses), numberOfDays,
                convertToDecimal(total));
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%d;%s", employeesAccount,
                convertToDecimal(transportationExpenses), numberOfDays, convertToDecimal(getTotal()));
    }

    public static String convertToDecimal(int value) {
        return String.format("%d.%02d", value / 100, value % 100);
    }

}
