package by.epam.lab.inheritance;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        Purchase[] purchases = new Purchase[6];
        Path path = Path.of("java/src/in.txt");

        try (Scanner scanner = new Scanner(path)) {
            boolean flag = true;
            double maxCost = 0d;
            Purchase expensivePurchase = null;
            for (int i = 0; i < purchases.length; i++) {
                TypePurchase type = TypePurchase.valueOf(scanner.next());
                String name = scanner.next();
                Byn price = new Byn();
                price.kopeck = scanner.nextInt();
                int quantity = scanner.nextInt();
                purchases[i] = new Purchase(name, price, quantity);

                if (maxCost < purchases[i].getCost()) {
                    maxCost = purchases[i].getCost();
                    expensivePurchase = purchases[i];
                }
                if (!purchases[0].equals(purchases[i])) {
                    flag = false;
                    System.out.print("new purchase in the list: ");
                } else {
                    System.out.print("first purchase in the list: ");
                }
                System.out.println(purchases[i]);
            }
            System.out.printf("the most expensive purchase: %s", expensivePurchase);


        } catch (IOException e) {
            System.out.println("file not found");
            e.printStackTrace();
        }
    }
}
