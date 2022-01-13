package by.epam.lab;

public class ExtraTrial extends Trial {
    private int mark3;

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
        return super.isPassed() && mark3 >= Mark.PASS_MARK3.getValue();
    }

    protected String fieldsToString() {
        return super.fieldsToString() + ";" + mark3;
    }

    @Override
    public Trial refreshMarks() {
        super.refreshMarks();
        mark3 = 0;
        return this;
    }

    @Override
    public ExtraTrial clone() {
        ExtraTrial o;
        o = (ExtraTrial) super.clone();
        return o;
    }
}
