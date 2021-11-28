package by.gsu.epamlab.task3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

import static by.gsu.epamlab.task3.MoneyConverter.*;

public class Runner {

    public static void main(String[] args) throws IOException {

        Path path = Path.of("java/src/in.txt");
        try (Scanner scanner = new Scanner(path)) {
            final int PURCHASES_NUMBER = scanner.nextInt();
            Purchase[] purchases = new Purchase[PURCHASES_NUMBER];

            System.out.printf("%s;%d\n", Purchase.NAME, Purchase.PRICE);

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
            double meanCost = totalCost / purchases.length;
            System.out.printf("\naverage cost: %s\n", toConvert(meanCost));

            int mondayCost = 0;
            for (Purchase purchase : purchases) {
                if (purchase.getWeekDay().equals(WeekDay.MONDAY)) {
                    mondayCost += purchase.getCost();
                }
            }
            System.out.printf("monday cost: %s\n", toConvert(mondayCost));

            int maxCost = 0;
            for (Purchase purchase : purchases) {
                if (purchase.getCost() > maxCost) {
                    maxCost = (int) purchase.getCost();
                }
            }
            System.out.printf("max cost: %s\n", toConvert(maxCost));

            System.out.println("\nincrease:\n" + Purchase.NAME + ";" + Purchase.PRICE);
            Arrays.sort(purchases);
            for (Purchase purchase : purchases) {
                System.out.println(purchase);
            }
            Purchase searchPurchase = new Purchase(5, 0, 0);
            int index = Arrays.binarySearch(purchases, searchPurchase);
            System.out.printf("\n5 pieces purchase: %s", purchases[index]);

        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }


    }
}
