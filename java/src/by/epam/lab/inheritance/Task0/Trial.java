package by.epam.lab.inheritance.Task0;

import java.util.Objects;

public class Trial {
    public static final int PASS_MARK = 120;
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

    protected int result() {
        return mark1 + mark2;
    }

    public boolean isPassed() {
        return result() >= PASS_MARK;
    }

    @Override
    public String toString() {
        return String.format("%s;%d;%d;%b",
                name, mark1, mark2, isPassed());
    }

    public double findArithmeticMeanValue() {
        return (mark1 + mark2) * 0.5;
    }

    public void refreshMarks() {
        mark1 = 0;
        mark2 = 0;
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
}
