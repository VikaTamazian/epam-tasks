package by.epam.lab.inheritance.Task0;

public class ExtraTrial extends Trial {
    private int mark3;
    private static final int PASS_MARK3 = 65;

    public ExtraTrial(int mark3) {
    }

    public ExtraTrial(String name, int mark1, int mark2, int mark3) {
        super(name, mark1, mark2);
        this.mark3 = mark3;
    }

    public int getMark3() {
        return mark3;
    }

    @Override
    public boolean isPassed() {
        return super.isPassed() && mark3 >= PASS_MARK3;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(";%d", mark3);
    }

    @Override
    protected int result() {
        return super.result() + mark3;
    }

    @Override
    public double findArithmeticMeanValue() {
        return result() / 3.0;
    }

    @Override
    public void refreshMarks() {
        super.refreshMarks();
        mark3 = 0;
    }
}
