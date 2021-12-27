package by.epam.lab;

import java.util.Locale;

public enum Weekday {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    @Override
    public String toString() {

        return name().toLowerCase(Locale.ROOT);
    }
}
