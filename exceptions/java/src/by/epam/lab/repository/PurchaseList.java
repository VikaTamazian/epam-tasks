package by.epam.lab.repository;

import by.epam.lab.bean.Byn;
import by.epam.lab.bean.Purchase;
import by.epam.lab.util.PurchaseFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class PurchaseList {
    private List<Purchase> purchases;
    private final Comparator<Purchase> comparator;
    private boolean flag = false;

    public PurchaseList(Path path, Comparator<Purchase> comparator) {
        purchases = new ArrayList<>();
        this.comparator = comparator;
        try (Scanner scanner = new Scanner(path)) {
            purchases = scanner.tokens()
                    .map(PurchaseFactory::getPurchase)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File not found");
        }
    }


    public void printAll() {
        purchases.forEach(System.out::println);
    }

    public void addPurchase(int index, Purchase purchase) {
        if (index > purchases.size() || index < 0) {
            purchases.add(purchase);
            index = purchases.size() - 1;
        } else {
            purchases.add(index, purchase);
        }
        flag = false;
    }

    public Byn findTotalCost() {
        Byn sum = new Byn(0);
        for (Purchase purchase : purchases) {
            sum = sum.add(purchase.getCost());
        }
        return sum;
    }

    public void sortPurchaseList() {
        purchases.sort(comparator);
        flag = true;
    }

    public void binary(Purchase purchase) {
        if (!flag) {
            purchases.sort(comparator);
        }
        int index = Collections.binarySearch(purchases, purchase, comparator);
        if (index >= 0) {
            System.out.println(purchase);
        }
    }

    public void deletePurchase(int first, int second) {

        try {
            purchases.subList(first, second).clear();
            flag = false;
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException();
        }


    }

    public String toString() {
        return purchases.stream().map(Purchase::toString).collect(Collectors.joining("\n"));

    }


}

