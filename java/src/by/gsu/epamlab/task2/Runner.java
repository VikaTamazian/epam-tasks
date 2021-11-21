package by.gsu.epamlab.task2;

public class Runner {

    public static void main(String[] args) {
        Material steel = new Material("steel", 7850.0);
        Material copper = new Material("copper", 8500.0);
        Subject steelWire = new Subject("wire", steel, 0.03);
        Subject copperWire = new Subject("wire", copper, 0.03);
        
        System.out.println(steelWire);
        steelWire = copperWire;
        System.out.println(steelWire);
    }
}
