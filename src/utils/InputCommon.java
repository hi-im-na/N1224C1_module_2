package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class InputCommon implements AutoCloseable {
    private final Scanner sc = new Scanner(System.in);

    public String checkInputString() {
        String result = "";
        while (true) {
            result = sc.nextLine();
            if (result == null || result.trim().isEmpty()) {
                System.err.print("Can not be blank. Please enter again: ");
            } else {
                return result;
            }
        }
    }

    /**
     * Check input integer
     *
     * @return an integer
     */
    public int checkInputInt() {
        while (true) {
            try {
                return Integer.parseInt(checkInputString());
            } catch (NumberFormatException e) {
                System.err.print("Please input a valid integer: ");
            }
        }
    }

    /**
     * Check input integer limit
     *
     * @param number an integer
     * @param type   used to specify the number provided is max or min
     * @return an integer in range (-inf, range) or (range, +inf)
     */
    public int checkInputInt(CheckInputType type, int number) {
        while (true) {
            try {
                int result = Integer.parseInt(checkInputString());
                if (type == CheckInputType.MAX && result > number) {
                    throw new NumberFormatException();
                }
                if (type == CheckInputType.MIN && result < number) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                if (type == CheckInputType.MAX) {
                    System.err.print("Please input a valid integer (-inf, " + number + "): ");
                } else {
                    System.err.print("Please input a valid integer [" + number + ", +inf): ");
                }
            }
        }
    }

    /**
     * Check input integer limit
     *
     * @param min minimum value
     * @param max maximum value
     * @return an integer in range [min, max]
     */
    public int checkInputInt(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(checkInputString());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.print("Please input a valid integer [" + min + "-" + max + "]: ");
            }
        }
    }

    /**
     * Check input integer limit exclude range
     *
     * @param min          minimum value
     * @param max          maximum value
     * @param excludeRange list of values that are not allowed
     * @return an integer in range [min, max] and not in excludeRange
     */
    public int checkInputInt(int min , int max, List<Integer> excludeRange) {
        while (true) {
            try {
                int result = Integer.parseInt(checkInputString());
                if (result < min || result > max || excludeRange.contains(result)) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.printf("Please input a valid integer [%d-%d] and not in %s: ", min, max, excludeRange);
            }
        }

    }

    /**
     * Check input double
     *
     * @return a double
     */
    public double checkInputDouble() {
        while (true) {
            try {
                return Double.parseDouble(checkInputString());
            } catch (NumberFormatException e) {
                System.err.print("Please input a valid double: ");
            }
        }
    }

    /**
     * Check input double limit
     *
     * @param number a double
     * @param type   used to specify the number provided is max or min
     * @return a double in range (-inf, range) or (range, +inf)
     */
    public double checkInputDouble(CheckInputType type, double number) {
        while (true) {
            try {
                double result = Double.parseDouble(checkInputString());
                if (type == CheckInputType.MAX && result > number) {
                    throw new NumberFormatException();
                }
                if (type == CheckInputType.MIN && result < number) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                if (type == CheckInputType.MAX) {
                    System.err.print("Please input a valid double (-inf, " + number + "): ");
                } else {
                    System.err.print("Please input a valid double [" + number + ", +inf): ");
                }
            }
        }
    }

    /**
     * Check input double limit
     *
     * @param min minimum value
     * @param max maximum value
     * @return a double in range [min, max]
     */
    public double checkInputDouble(double min, double max) {
        while (true) {
            try {
                double result = Double.parseDouble(checkInputString());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.print("Please input a valid double (" + min + "-" + max + "): ");
            }
        }
    }

    /**
     * Check input date with format
     *
     * @param dateInputFormat format of date
     * @return a date
     */
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

    /**
     * Check input value if it is matched with one of the enum values
     *
     * @param enumType type
     * @return Enum value
     */
    public <E extends Enum<E>> String checkInputEnum(Class<E> enumType) {
        while (true) {
            try {
                String value = checkInputString().toUpperCase(Locale.ROOT);
                for (E e : enumType.getEnumConstants()) {
                    if (e.name().equals(value)) {
                        return value;
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

    @Override
    public void close() {
        try {
            sc.close();
        } catch (Exception e) {
            System.err.println("Error close InputValidate: " + e.getMessage());
        }
    }
}
