package by.epam.lab.exception;

public class BynValueException extends IllegalArgumentException {

    private final String message;

    public BynValueException(Exception exception, String message) {
        super(exception);
        this.message = message;
    }

    public BynValueException(String message) {
        this.message = message;
    }


    public String toString() {
        return message + TypeException.ERROR_BYN_VALUE_IS_UNREAL + getMessage();
    }
}
