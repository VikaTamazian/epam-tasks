package by.epam.lab;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class Runner {

    public static void main(String[] args) {
        final Path path = Path.of("recourses", "in.csv");

        try (Scanner scanner = new Scanner(path)) {
            Map<Purchase, Weekday> firstPurchasesMap = new HashMap<>();
            Map<Purchase, Weekday> lastPurchasesMap = new HashMap<>();
            Map<Weekday, List<Purchase>> dayPurchasesMap = new EnumMap<>(Weekday.class);
            List<PricePurchase> priceDiscountPurchases = new ArrayList<>();

            while (scanner.hasNext()) {
                Purchase purchaseFromFactory = PurchaseFactory.createPurchaseFromFactory(scanner);
                Weekday weekday = Weekday.valueOf(scanner.next());
                if (!lastPurchasesMap.containsKey(purchaseFromFactory)) {
                    lastPurchasesMap.put(purchaseFromFactory, weekday);
                }

                if (!firstPurchasesMap.containsKey(purchaseFromFactory)) {
                    firstPurchasesMap.put(purchaseFromFactory, weekday);
                }

                if (!dayPurchasesMap.containsKey(weekday)) {
                    dayPurchasesMap.put(weekday, new ArrayList<>());
                }
                dayPurchasesMap.get(weekday).add(purchaseFromFactory);

                if (purchaseFromFactory.getClass() == PricePurchase.class) {
                    priceDiscountPurchases.add((PricePurchase) purchaseFromFactory);
                }
            }

            toPrint(lastPurchasesMap, "last purchase map:");
            toPrint(firstPurchasesMap, "first purchase map:");
            toSearch(firstPurchasesMap, new Purchase("bread", new Byn(155), 1));
            toSearch(lastPurchasesMap, new Purchase("bread", new Byn(155), 1));
            toSearch(firstPurchasesMap, new Purchase("bread", new Byn(170), 1));

            removeEntries(firstPurchasesMap, new EntryChecker<Purchase, Weekday>() {
                @Override
                public boolean check(Map.Entry<Purchase, Weekday> entry) {
                    return entry.getKey().getName().equals("meat");
                }
            });

            removeEntries(lastPurchasesMap, new EntryChecker<Purchase, Weekday>() {
                @Override
                public boolean check(Map.Entry<Purchase, Weekday> entry) {
                    return entry.getValue() == Weekday.FRIDAY;
                }
            });


            toPrint(lastPurchasesMap, "last purchase map:");
            toPrint(firstPurchasesMap, "first purchase map:");
            getCost(priceDiscountPurchases);
            toPrint(dayPurchasesMap, "According to the day");
            getCost(dayPurchasesMap, Weekday.MONDAY);
            System.out.println("Monday purchases:");
            toSearch(dayPurchasesMap, Weekday.MONDAY);


        } catch (IOException e) {
            System.err.println("Input file is not found");
            e.printStackTrace();
        }
    }


    private static <K, V> void toSearch(Map<K, V> map, K key) {
        if (map.containsKey(key)) {
            System.out.println(map.get(key));
        } else {
            System.out.println("Does not exists");
        }
        System.out.println();
    }

    private static <K, V> void toPrint(Map<K, V> map, String message) {
        System.out.println(message);
        for (K keyElement : map.keySet()) {
            System.out.println(keyElement + "=>" + map.get(keyElement));
        }
        System.out.println();
    }


    private static <K, V> void removeEntries(Map<K, V> map, EntryChecker checker) {
        for (Iterator<Map.Entry<K, V>> entry = map.entrySet().iterator();
             entry.hasNext(); ) {
            if (checker.check(entry.next())) {
                entry.remove();
            }
        }
    }

    private static EnumMap<Weekday, List<Purchase>> removeEntries(EnumMap<Weekday, List<Purchase>> map, String name) {
        EnumMap<Weekday, List<Purchase>> innerMap = new EnumMap<Weekday, List<Purchase>>(Weekday.class);
        for (Map.Entry<Weekday, List<Purchase>> entry : map.entrySet()) {
            List<Purchase> innerList = new ArrayList<>();
            Weekday weekDay = entry.getKey();
            List<Purchase> list = map.get(weekDay);
            for (Purchase purchase : entry.getValue()) {
                if (!purchase.getName().equals(name)) {
                    innerList.add(purchase);
                }
            }
            innerMap.put(weekDay, innerList);
        }
        return innerMap;
    }

    private static Byn getCost(Collection<? extends Purchase> collection) {
        Iterator<? extends Purchase> iterator = collection.iterator();
        Byn result = new Byn(0);
        while (iterator.hasNext()) {
            result = iterator.next().getCost().add(result);
        }
        return result;
    }

    private static void getCost(Map<Weekday, List<Purchase>> collection, Weekday weekday) {
        Byn totalCost = new Byn(0);
        for (Map.Entry<Weekday, List<Purchase>> purchase : collection.entrySet()) {
            if (purchase.getKey() == weekday) {
                for (Purchase p : purchase.getValue()) {
                    totalCost = totalCost.add(p.getCost());
                }
            }
        }
    }

}