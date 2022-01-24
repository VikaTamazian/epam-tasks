package by.epam.lab.test;

import by.epam.lab.bean.Byn;
import by.epam.lab.bean.PriceDiscountPurchase;
import by.epam.lab.bean.Purchase;
import by.epam.lab.repository.PurchaseList;
import by.epam.lab.util.PurchaseFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestRunner {
    private PurchaseList purchaseList;
    private static final Path PATH = Path.of("exceptions", "in.csv");
    private static final Path PATH_FOR_TEST = Path.of("exceptions", "inForTest.csv");
    private static final String CORRECT_CSV = "purchase;100;1;2";
    private static final int CORRECT_CSV_LENGTH = 8;
    private static final Purchase PURCHASE = new PriceDiscountPurchase("purchase", new Byn(100), 1, new Byn(2));
    private static final Byn TOTAL_COST_EXPECTED = new Byn(4873);


    @Before
    public void readPurchaseListTest() {
        purchaseList = new PurchaseList(PATH_FOR_TEST, Comparator.comparing(Purchase::getName));
    }

    @Test
    public void PurchaseListConstructorTest() {

        new PurchaseList(PATH_FOR_TEST, Comparator.comparing(Purchase::getName));
        new PurchaseList(PATH_FOR_TEST, Comparator.comparing(Purchase::getPrice));
        new PurchaseList(PATH_FOR_TEST, Comparator.comparing(Purchase::getQuantity));
        new PurchaseList(PATH_FOR_TEST, Comparator.comparing(Purchase::getCost));

        Assert.assertTrue(true);

    }

    @Test
    public void addAllToListFromCorrectCsvTest() throws IOException {
        List<Optional<Purchase>> purchases = new ArrayList<>();
        Scanner scanner = new Scanner(PATH_FOR_TEST);
        while (scanner.hasNext()) {
            Optional<Purchase> purchase = PurchaseFactory.getPurchase(scanner.next());
            purchases.add(purchase);
        }
        assertEquals(CORRECT_CSV_LENGTH, purchases.size());

    }


    @Test
    public void addPurchaseTest() {
        boolean insert;
        try {
            insert = true;
            purchaseList.addPurchase(1, PURCHASE);
        } catch (IndexOutOfBoundsException e) {
            insert = false;

        }
        Assert.assertTrue(insert);

    }

    @Test
    public void deletePurchaseTest() {
        boolean del;
        try {
            purchaseList.deletePurchase(2, 4);
            del = true;
        } catch (IndexOutOfBoundsException e) {
            del = false;

        }
        Assert.assertTrue(del);

    }

    @Test
    public void findTotalCostTest() {
        Byn actual = purchaseList.findTotalCost();
        assertEquals(TOTAL_COST_EXPECTED, actual);
    }


    @Test
    public void correctCreationOfPurchaseTest() {
        assertNotNull(PurchaseFactory.getPurchase(CORRECT_CSV));
        assertEquals(PURCHASE.getName(), PurchaseFactory.getPurchase(CORRECT_CSV).get().getName());
        assertEquals(PURCHASE.getPrice(), PurchaseFactory.getPurchase(CORRECT_CSV).get().getPrice());
        assertEquals(PURCHASE.getQuantity(), PurchaseFactory.getPurchase(CORRECT_CSV).get().getQuantity());
    }

}
