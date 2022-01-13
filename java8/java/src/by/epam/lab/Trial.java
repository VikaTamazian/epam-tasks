package by.epam.lab;

import java.util.Objects;

public class Trial implements Cloneable {
    private String name;
    private int mark1;
    private int mark2;

    public Trial() {
    }

    public Trial(String name, int mark1, int mark2) {
        this.name = name;
        this.mark1 = mark1;
        this.mark2 = mark2;
    }

    public int getMark1() {
        return mark1;
    }

    public int getMark2() {
        return mark2;
    }

    public String getName() {
        return name;
    }

    protected double result() {
        return mark1 + mark2;
    }

    public boolean isPassed() {
        return result() >= Mark.PASS_MARK.getValue();
    }


    @Override
    public String toString() {
        return fieldsToString() + ";" + isPassed();
    }

    protected String fieldsToString() {
        return String.format("%s;%d;%d", name, mark1, mark2);
    }


    public Trial refreshMarks() {
        mark1 = 0;
        mark2 = 0;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trial trial = (Trial) o;
        return mark1 == trial.mark1 && mark2 == trial.mark2 && Objects.equals(name, trial.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mark1, mark2);
    }


    @Override
    public Trial clone() {
        Trial o;
        try {
            o = (Trial) super.clone();
            return o;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
