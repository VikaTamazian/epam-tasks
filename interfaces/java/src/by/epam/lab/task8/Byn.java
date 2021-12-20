package by.epam.lab.task8;

public class Byn implements Comparable<Byn> {
    private final int value;

    public Byn() {
        value = 0;
    }

    public Byn(int value) {
        this.value = value;
    }

    public Byn(int rubs, int coins) {
        this(rubs * 100 + coins);

    }

    public Byn(Byn byn) {
        this(byn.value);

    }

    public Byn add(Byn byn) {
        return new Byn(value + byn.value);
    }

    public Byn sub(Byn byn) {
        return new Byn(value - byn.value);
    }

    public Byn mul(double k, RoundMethod roundMethod, int d) {
        return new Byn(roundMethod.round(value * k, d));
    }

    public Byn mul(int k) {
        return new Byn(value * k);
    }


    public Byn round(RoundMethod roundMethod, int d) {
        return new Byn(roundMethod.round(value, d));

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Byn byn = (Byn) o;
        return value == byn.value;
    }

    @Override
    public String toString() {
        return String.format("%d.%02d", value / 100, value % 100);
    }


    @Override
    public int compareTo(Byn o) {
        return o.value - value;
    }


}


