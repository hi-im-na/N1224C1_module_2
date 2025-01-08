package ss10_exception.excercises.validation;

import ss10_exception.excercises.exception.EmptyFieldException;
import ss10_exception.excercises.exception.MinLengthException;
import ss10_exception.excercises.exception.NegativeNumberException;
import ss10_exception.excercises.exception.NumberOutOfRangeException;

public class CommonValidation {
    public static void validateIsEmpty(String value, String fieldName) throws EmptyFieldException {
        if (value == null || value.isEmpty()) {
            throw new EmptyFieldException(fieldName + " must not be empty");
        }
    }

    public static int parseInt(String value, String fieldName) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(fieldName + " must be a integer");
        }
    }

    public static double parseDouble(String value, String fieldName) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(fieldName + " must be a double");
        }
    }

    public static void validateNumberOutOfRangeException(double value, String fieldName, double minValue, double maxValue) throws NumberOutOfRangeException {
        if (value < minValue || value > maxValue) {
            throw new NumberOutOfRangeException(fieldName + " must be in range [" + minValue + ", " + maxValue + "]");
        }
    }

    public static void validateMinLength(String value, String fieldName, int minLength) throws MinLengthException {
        if (value.length() < minLength) {
            throw new MinLengthException(fieldName + " must have at least " + minLength + " characters");
        }
    }

    public static void validateIsNegativeNumber(double value, String fieldName) throws NegativeNumberException {
        if (value < 0) {
            throw new NumberOutOfRangeException(fieldName + " must be a positive number");
        }
    }
}
