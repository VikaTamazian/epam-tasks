package by.gsu.epamlab.task2;

public final class Material {
    private String name;
    private double density;

    public Material(String name, double density) {
        this.name = name;
        this.density = density;
    }

    public Material() {
    }

    public String getName() {
        return name;
    }

    public double getDensity() {
        return density;
    }

    @Override
    public String toString() {
        return (name + ";" + density);
    }
}
