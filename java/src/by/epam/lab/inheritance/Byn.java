package by.epam.lab.inheritance;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Byn implements Comparable<Byn> {
    protected int kopeck;

    public Byn() {
    }

    public Byn(int kopeck) {
        this.kopeck = kopeck;
    }

    @Override
    public String toString() {
        return String.format("%.2f", kopeck / 100.00);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Byn byn = (Byn) o;
        return kopeck == byn.kopeck;
    }

    @Override
    public int hashCode() {
        return Objects.hash(kopeck);
    }


    @Override
    public int compareTo(@NotNull Byn o) {
        return (kopeck - o.kopeck);
    }
}
