package by.gsu.epamlab.task1;

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
        BusinessTrip expensiveTrip = null;
        for (BusinessTrip trip : trips) {

            if (trip != null && (trip.getNumberOfDays() != 0)) {
                trip.show(trip.getEmployeesAccount(), trip.getTransportationExpenses(), trip.getNumberOfDays());
                if (maxTotal < trip.getTotal()) {
                    maxTotal = trip.getTotal();
                    expensiveTrip = trip;
                }
            }
        }
        System.out.printf("business trip with maximum cost: %s \n", expensiveTrip);


        trips[trips.length - 1].setTransportationExpenses(650);


        System.out.printf("duration: %d\n", (trips[0].getNumberOfDays() + trips[1].getNumberOfDays()));

        for (BusinessTrip trip : trips) {
            System.out.printf("%s", trip);

        }
    }
}
