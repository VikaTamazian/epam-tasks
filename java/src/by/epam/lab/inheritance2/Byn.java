package by.epam.lab.inheritance2;

import org.jetbrains.annotations.NotNull;

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
        this(byn.getValue());

    }

    public Byn add(Byn byn) {
        return new Byn(value + byn.value);
    }

    public Byn sub(Byn byn) {
        return new Byn(value - byn.value);
    }

    public int getValue() {
        return value;
    }

    public Byn mul(double k, RoundMethod roundMethod, int d) {
        int tenPow = pow(d);
        return new Byn((int) roundMethod.roundFunction(value * k / tenPow) * tenPow);
    }

    public Byn mul(int k) {
        return new Byn(value * k);
    }


    public Byn round(RoundMethod roundMethod, int d) {
        int tenPow = pow(d);
        return new Byn((int) roundMethod.roundFunction((double) value / tenPow) * tenPow);

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
    public int compareTo(@NotNull Byn o) {
        return o.value - value;
    }

    private static int pow(int powValue) {
        int result = 1;
        for (int i = 1; i <= powValue; i++) {
            result = result * 10;
        }
        return result;
    }
}

