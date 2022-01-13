package by.epam.lab;

public enum Mark {
    PASS_MARK (120),
    PASS_MARK1 (35),
    PASS_MARK2 (60),
    PASS_MARK3 (65);

    private int value;

    Mark(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }


}
