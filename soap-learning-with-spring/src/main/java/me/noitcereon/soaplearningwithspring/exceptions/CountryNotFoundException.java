package me.noitcereon.soaplearningwithspring.exceptions;

public class CountryNotFoundException extends RuntimeException{
    public CountryNotFoundException() {
        super("Could not find the country in our dataset.");
    }

    public CountryNotFoundException(String message) {
        super(message);
    }

    public CountryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CountryNotFoundException(Throwable cause) {
        super(cause);
    }

    public CountryNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
