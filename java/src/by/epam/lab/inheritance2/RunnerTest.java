package by.epam.lab.inheritance2;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RunnerTest {


    @Test
    public void constructorWithRubAndCoinsTest() {
        Byn byn1 = new Byn(1438);
        Byn byn2 = new Byn(14, 38);
        Assert.assertNotNull(byn1);
        Assert.assertNotNull(byn2);
        Assert.assertEquals(byn1, byn2);
        Assert.assertEquals(byn2.toString(), "14.38");
    }

    @Test
    public void constructorBynTest() {
        Byn byn1 = new Byn(1700);
        Byn byn2 = new Byn(1700);
        Assert.assertNotNull(byn1);
        Assert.assertNotNull(byn2);
        Assert.assertEquals(byn1, byn2);

    }

    @Test
    public void addTest() {
        Byn byn1 = new Byn(1000);
        Byn byn2 = new Byn(200);
        Byn bynSum = byn1.add(byn2);
        Assert.assertNotNull(bynSum);
        Assert.assertEquals("12.00", bynSum.toString());

    }

    @Test
    public void subTest() {
        Byn byn1 = new Byn(1000);
        Byn byn2 = new Byn(200);
        Byn bynSub = byn1.sub(byn2);
        Assert.assertNotNull(bynSub);
        Assert.assertEquals("8.00", bynSub.toString());

    }

    @Test
    public void mulTwoValuesTest() {
        Byn byn1 = new Byn(1000);
        Byn bynMul = byn1.mul(6);
        Assert.assertNotNull(bynMul);
        Assert.assertEquals("60.00", bynMul.toString());

    }

    @Test
    public void mulTwoValuesWithEnumRoundTest() {
        Byn byn1 = new Byn(1033);
        Byn bynMul = byn1.mul(6.5, RoundMethod.ROUND, 0);
        Assert.assertNotNull(bynMul);
        Assert.assertEquals("67.15", bynMul.toString());

    }

    @Test
    public void mulTwoValuesWithEnumFloorTest() {
        Byn byn1 = new Byn(1033);
        Byn bynMul = byn1.mul(6.5, RoundMethod.FLOOR, 2);
        Assert.assertNotNull(bynMul);
        Assert.assertEquals("67.00", bynMul.toString());

    }

    @Test
    public void constructorNullProductTest() {
        Product product = new Product();
        Assert.assertEquals(product, new Product());
        Assert.assertEquals(product.toString(), ";0.00");
    }

    @Test
    public void constructorWithArgsProductTest() {
        Product product = new Product("a", new Byn(70));
        Assert.assertNotNull(product);
        Assert.assertEquals("a;0.70", product.toString());
    }

    @Test
    public void constructorPurchaseTest() {
        UnitDiscountPurchase purchase1 = new UnitDiscountPurchase(new Product(), 4, new Byn());
        QuantityDiscountPurchase purchase2 = new QuantityDiscountPurchase(new Product(), 4, 15.50);
        TransportPurchase purchase3 = new TransportPurchase(new Product(), 4, new Byn());

        Assert.assertNotNull(purchase1);
        Assert.assertNotNull(purchase2);
        Assert.assertNotNull(purchase3);
        Assert.assertEquals(purchase1.toString(), ";0.00;4;0.00;0.00");
        Assert.assertEquals(purchase2.toString(), ";0.00;4;15.5;0.00");
        Assert.assertEquals(purchase3.toString(), ";0.00;4;0.00;0.00");
    }

    @Test
    public void getFinalCostUnitDiscountPurchaseTest() {
        UnitDiscountPurchase purchase1 = new UnitDiscountPurchase(new Product(), 4, new Byn());
        Byn cost = purchase1.getFinalCost(new Byn(45));
        Assert.assertEquals("0.45", cost.toString());
    }

    @Test
    public void getFinalCostQuantityDiscountPurchaseTest() {
        QuantityDiscountPurchase purchase2 = new QuantityDiscountPurchase(new Product(), 40, 15.50);
        Byn cost = purchase2.getFinalCost(new Byn(45));
        Assert.assertEquals("0.38", cost.toString());
    }

    @Test
    public void getFinalCostTransportPurchaseTest() {
        TransportPurchase purchase3 = new TransportPurchase(new Product(), 4, new Byn());
        Byn cost = purchase3.getFinalCost(new Byn(2525));
        Assert.assertEquals("25.25", cost.toString());
    }

    @Test
    public void mainFindProductTest() {
        Product product = new Product("a", new Byn(50));
        AbstractPurchase[] purchases = {
                new UnitDiscountPurchase(product, 8, new Byn(10)),
                new UnitDiscountPurchase(product, 10, new Byn(0)),
                new QuantityDiscountPurchase(product, 13, 200),
                new QuantityDiscountPurchase(product, 120, 4050),
                new TransportPurchase(product, 20, new Byn(50)),
                new TransportPurchase(product, 5, new Byn(140)),
        };
        Arrays.sort(purchases);
        String message = Runner.toSearch(purchases);
        Assert.assertEquals("a;0.50;10;0.00;5.00", message);
    }

    @Test
    public void mainNoSuchProductTest() {
        Product product = new Product("a", new Byn(50));
        AbstractPurchase[] purchases = {
                new UnitDiscountPurchase(product, 8, new Byn(10)),
                new UnitDiscountPurchase(product, 11, new Byn(150)),
                new QuantityDiscountPurchase(product, 13, 200),
                new QuantityDiscountPurchase(product, 120, 4050),
                new TransportPurchase(product, 20, new Byn(50)),
                new TransportPurchase(product, 5, new Byn(140)),
        };
        Arrays.sort(purchases);
        String message = Runner.toSearch(purchases);
        Assert.assertEquals("Nothing was found", message);
    }

}
