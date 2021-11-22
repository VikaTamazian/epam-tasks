package by.gsu.epamlab.task3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) throws IOException {

        Path path = Path.of("java/src/in.txt");
        try (Scanner scanner = new Scanner(path)) {
            final int PURCHASES_NUMBER = scanner.nextInt();
            Purchase[] purchases = new Purchase[PURCHASES_NUMBER];

            System.out.println(Purchase.NAME + ";" + Purchase.PRICE);

            int i = 0;
            while (scanner.hasNext()) {

                var quantity = scanner.nextInt();
                var discount = scanner.nextInt();
                WeekDay day = WeekDay.values()[scanner.nextInt()];
                purchases[i] = new Purchase(quantity, discount, day);
                System.out.println(purchases[i]);
                i++;

            }

            int totalCost = 0;
            for (Purchase purchase : purchases) {
                totalCost += purchase.getCost();
            }
            int meanCost = totalCost / purchases.length;
            System.out.printf("average cost: %s.000\n", meanCost / 100);

            int mondayCost = 0;
            for (Purchase purchase : purchases) {
                if (purchase.getWeekDay().equals(WeekDay.MONDAY)) {
                    mondayCost += purchase.getCost();
                }
            }
            System.out.printf("monday cost: %s.00\n", mondayCost / 100);

            int maxCost = 0;
            for (Purchase purchase : purchases) {
                if (purchase.getCost() > maxCost) {
                    maxCost = purchase.getCost();
                }
            }
            System.out.printf("max cost: %s.00\n", maxCost / 100);

            System.out.println(Purchase.NAME + ";" + Purchase.PRICE);
            Arrays.sort(purchases);
            for (Purchase purchase : purchases) {
                System.out.println(purchase);
            }
            int index = Arrays.binarySearch(purchases, purchases[5]);
            System.out.printf("sorted #5 purchase: %s", purchases[index]);

        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }


    }
}
