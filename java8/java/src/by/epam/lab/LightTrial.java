package by.epam.lab;

public class LightTrial extends Trial {


    public LightTrial() {
    }

    public LightTrial(String name, int mark1, int mark2) {
        super(name, mark1, mark2);
    }

    @Override
    public boolean isPassed() {
        return getMark1() >= Mark.PASS_MARK1.getValue() && getMark2() >= Mark.PASS_MARK2.getValue();
    }

    @Override
    public LightTrial clone() {
        LightTrial o;
        o = (LightTrial) super.clone();
        return o;
    }
}
