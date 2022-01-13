package by.epam.lab;

public class StrongTrial extends Trial {
    private static final double MARK_1_COEFFICIENT = 0.5;


    public StrongTrial() {
    }

    public StrongTrial(String name, int mark1, int mark2) {
        super(name, mark1, mark2);
    }

    @Override
    protected double result() {
        return getMark1() * MARK_1_COEFFICIENT + getMark2();
    }

    @Override
    public StrongTrial clone() {
        StrongTrial o;
        o = (StrongTrial) super.clone();
        return o;
    }

}
