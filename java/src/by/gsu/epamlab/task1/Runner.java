package by.gsu.epamlab.task1;

import static by.gsu.epamlab.task1.BusinessTrip.convertToDecimal;

public class Runner {
    public static void main(String[] args) {
        BusinessTrip[] trips = {
                new BusinessTrip("test", 800, 3),
                new BusinessTrip("test1", 1650, 7),
                null,
                new BusinessTrip("test3", 500, 2),
                new BusinessTrip()
        };

        int maxTotal = 0;
        for (BusinessTrip trip : trips) {

            if (trip != null && (trip.getNumberOfDays() != 0)) {
                trip.show(trip.getEmployeesAccount(), trip.getTransportationExpenses(), trip.getNumberOfDays());
                int tripTotal = trip.getTotal();
                if (maxTotal < tripTotal) {
                    maxTotal = tripTotal;
                }
            }
        }
        System.out.printf("business trip with maximum cost: %s \n", convertToDecimal(maxTotal));

        trips[trips.length - 1].setEmployeesAccount("test4");
        trips[trips.length - 1].setTransportationExpenses(650);
        trips[trips.length - 1].setNumberOfDays(2);

        System.out.println("duration: " + (trips[0].getNumberOfDays() + trips[1].getNumberOfDays()) + "\n");

        for (BusinessTrip trip : trips) {
            System.out.println(trip);

        }
    }
}
