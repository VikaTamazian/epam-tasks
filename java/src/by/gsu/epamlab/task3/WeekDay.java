package by.gsu.epamlab.task3;

import java.util.Locale;

public enum WeekDay {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;


    @Override
    public String toString() {
        return name().toLowerCase(Locale.ROOT);
    }
}
