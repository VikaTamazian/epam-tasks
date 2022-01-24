package by.epam.lab.exception;

import java.util.Locale;

public enum TypeException {
    ERROR_BYN_VALUE_IS_UNREAL,
    ERROR_FILE_NOT_FOUND,
    ERROR_EMPTY_NAME;


    @Override
    public String toString() {

        return name().toLowerCase(Locale.ROOT);
    }
}
