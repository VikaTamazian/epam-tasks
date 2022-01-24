package by.epam.lab.exception;

public class PurchaseException extends IllegalArgumentException {

    private final String message;

    public PurchaseException(Exception exception, String message) {
        super(exception);
        this.message = message;
    }

    public PurchaseException(String message) {
        this.message = message;
    }


    public String toString() {
        return message + TypeException.ERROR_EMPTY_NAME + getMessage();
    }
}
