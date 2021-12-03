package by.epam.lab.inheritance.Task0;

public class StrongTrial extends Trial {
    private static final int MARK1_COEFF = 2;

    public StrongTrial() {
    }

    public StrongTrial(String name, int mark1, int mark2) {
        super(name, mark1, mark2);
    }

    @Override
    protected int result() {
        return getMark1() / MARK1_COEFF + getMark2();
    }
}

