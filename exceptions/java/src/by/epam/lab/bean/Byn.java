package by.epam.lab.bean;

import by.epam.lab.exception.TypeException;
import by.epam.lab.util.RoundMethod;
import by.epam.lab.exception.BynValueException;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Scanner;

public class Byn implements Comparable<Byn> {
    private final int value;

    public Byn(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("wrong value for Byn: " + value);
        }
        this.value = value;
    }

    public Byn() {
        this(0);
    }

    public Byn(Byn byn) {
        this(byn.value);
    }

    public Byn(Scanner scanner) {
        this(scanner.nextInt());
    }

    public Byn(int rubs, int kops) {
        if (rubs < 0 && kops < 0 || kops > 100) {
            throw new BynValueException(TypeException.ERROR_BYN_VALUE_IS_UNREAL.toString());
        }
        value = rubs * 100 + kops;
    }

    public Byn(String strKops) {
        this(Integer.parseInt(strKops));
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
    public String toString() {
        return String.format("%d.%02d", value / 100, value % 100);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Byn byn = (Byn) o;
        return value == byn.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }


    @Override
    public int compareTo(@NotNull Byn o) {
        return (value - o.value);
    }
}
