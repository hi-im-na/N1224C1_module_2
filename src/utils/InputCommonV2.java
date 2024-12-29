package utils;

import utils.enums.CheckInputLimit;
import utils.enums.DateInputFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class InputCommonV2 implements AutoCloseable {
    private final Scanner sc = new Scanner(System.in);

    public String checkInputString() {
        String input;
        while (true) {
            input = sc.nextLine();
            if (input == null || input.trim().isEmpty()) {
                System.err.print("Can not be blank. Please enter again: ");
            } else {
                return input;
            }
        }
    }

    /**
     * Check input number
     *
     * @return a number of type T
     */
    public <T> T checkNumberInput(Class<T> clazz) {
        while (true) {
            try {
                if (clazz == Integer.class) {
                    return clazz.cast(Integer.parseInt(checkInputString()));
                } else if (clazz == Double.class) {
                    return clazz.cast(Double.parseDouble(checkInputString()));
                } else {
                    throw new IllegalArgumentException("Invalid class type or not developed");
                }
            } catch (NumberFormatException e) {
                System.err.print("Please input a valid number of type " + clazz.getSimpleName() + ": ");
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * Check input number limit
     *
     * @param limitNumber a number that is used to set the limit
     * @param limitEnum   used to specify the number provided is max or min
     * @return a number in range (-inf, number) or (number, +inf)
     */
    public <T extends Number> T checkNumberInput(Class<T> clazz, CheckInputLimit limitEnum, T limitNumber) {
        while (true) {
            try {
                T input;
                switch (clazz.getSimpleName()) {
                    case "Integer" -> {
                        input = clazz.cast(Integer.parseInt(checkInputString()));
                        if ((limitEnum == CheckInputLimit.MAX && input.intValue() > limitNumber.intValue())
                                || (limitEnum == CheckInputLimit.MIN && input.intValue() < limitNumber.intValue())) {
                            throw new NumberFormatException();
                        }
                    }
                    case "Double" -> {
                        input = clazz.cast(Double.parseDouble(checkInputString()));
                        if ((limitEnum == CheckInputLimit.MAX && input.doubleValue() > limitNumber.doubleValue())
                                || (limitEnum == CheckInputLimit.MIN && input.doubleValue() < limitNumber.doubleValue())) {
                            throw new NumberFormatException();
                        }
                    }
                    default -> throw new IllegalArgumentException("Invalid class type or not developed");
                }
                return input;
            } catch (NumberFormatException e) {
                if (limitEnum == CheckInputLimit.MAX) {
                    System.err.print("Please input a valid integer (-inf, " + limitNumber + "): ");
                } else {
                    System.err.print("Please input a valid integer [" + limitNumber + ", +inf): ");
                }
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * Check input number limit
     *
     * @param min minimum value
     * @param max maximum value
     * @return a number in range [min, max]
     */
    public <T extends Number> T checkNumberInput(Class<T> clazz, T min, T max) {
        while (true) {
            try {
                T input;
                switch (clazz.getSimpleName()) {
                    case "Integer" -> {
                        input = clazz.cast(Integer.parseInt(checkInputString()));
                        if (input.intValue() < min.intValue() || input.intValue() > max.intValue()) {
                            throw new NumberFormatException();
                        }
                    }
                    case "Double" -> {
                        input = clazz.cast(Double.parseDouble(checkInputString()));
                        if (input.doubleValue() < min.doubleValue() || input.doubleValue() > max.doubleValue()) {
                            throw new NumberFormatException();
                        }
                    }
                    default -> throw new IllegalArgumentException("Invalid class type or not developed");
                }
                return input;
            } catch (NumberFormatException e) {
                System.err.print("Please input a valid number (" + min + "-" + max + "): ");
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public LocalDate checkInputDate(DateInputFormat dateInputFormat) {
        while (true) {
            try {
                String date = checkInputString();
                return switch (dateInputFormat) {
                    case DD_MM_YYYY -> LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    case MM_DD_YYYY -> LocalDate.parse(date, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
                    case YYYY_MM_DD -> LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
                };
            } catch (DateTimeParseException e) {
                System.err.printf("Please input a valid date (%s): ", dateInputFormat.getPattern());
            }
        }
    }

    public <E extends Enum<E>> E checkEnumInput(Class<E> enumType) {
        while (true) {
            try {
                String value = checkInputString().toUpperCase(Locale.ROOT);
                for (E e : enumType.getEnumConstants()) {
                    if (e.name().equals(value)) {
                        return e;
                    }
                }
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.err.print("Please input a valid value: ");
                for (E e1 : enumType.getEnumConstants()) {
                    System.err.print(e1.name().toLowerCase(Locale.ROOT) + " || ");
                }
                System.err.println();
            }
        }
    }

    public <T extends Number> T checkNumberInput(Class<T> clazz, T min, T max, List<T> excludeRange) {
        while (true) {
            try {
                T input;
                switch (clazz.getSimpleName()) {
                    case "Integer" -> {
                        input = clazz.cast(Integer.parseInt(checkInputString()));
                        if (input.intValue() < min.intValue() || input.intValue() > max.intValue() || excludeRange.contains(input)) {
                            throw new NumberFormatException();
                        }
                    }
                    case "Double" -> {
                        input = clazz.cast(Double.parseDouble(checkInputString()));
                        if (input.doubleValue() < min.doubleValue() || input.doubleValue() > max.doubleValue() || excludeRange.contains(input)) {
                            throw new NumberFormatException();
                        }
                    }
                    default -> throw new IllegalArgumentException("Invalid class type or not developed");
                }
                return input;
            } catch (NumberFormatException e) {
                System.err.print("Please input a valid number (" + min + "-" + max + ") and not in " + excludeRange + ": ");
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    @Override
    public void close() {
        try {
            sc.close();
        } catch (Exception e) {
            System.err.println("Error close InputValidate: " + e.getMessage());
        }
    }
}
