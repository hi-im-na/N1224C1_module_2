package ss10_exception.excercises.validation;

import java.util.Scanner;

public class PhoneValidation {
    private static final Scanner scanner = new Scanner(System.in);

    private static String inputString(String fieldName) {
        while (true) {
            try {
                System.out.print("Nhập vào " + fieldName + ": ");
                String input = scanner.nextLine();
                CommonValidation.validateIsEmpty(input, fieldName);
                return input;
            } catch (Exception e) {
//                e.printStackTrace();
                System.err.println(e.getMessage());
                System.err.println("Vui lòng nhập lại");
            }
        }
    }

    private static double inputDouble(String fieldName) {
        while (true) {
            try {
                String input = inputString(fieldName);
                double value = CommonValidation.parseDouble(input, fieldName);
                CommonValidation.validateIsNegativeNumber(value, fieldName);
                return value;
            } catch (Exception e) {
//                e.printStackTrace();
                System.err.println(e.getMessage());
                System.err.println("Vui lòng nhập lại");
            }
        }
    }

    private static int inputInt(String fieldName) {
        while (true) {
            try {
                String input = inputString(fieldName);
                int value = CommonValidation.parseInt(input, fieldName);
                CommonValidation.validateIsNegativeNumber(value, fieldName);
                return value;
            } catch (Exception e) {
//                e.printStackTrace();
                System.err.println(e.getMessage());
                System.err.println("Vui lòng nhập lại");
            }
        }
    }

    public static String inputName(String fieldName) {
        return inputString(fieldName);
    }

    public static double inputPrice(String fieldName) {
        return inputDouble(fieldName);
    }

    public static int inputWarranty(String fieldName) {
        return inputInt(fieldName);
    }

    public static String inputManufacturer(String fieldName) {
        return inputString(fieldName);
    }

    public static Integer inputBatteryPercentage(String fieldName) {
        while (true) {
            try {
                int value = inputInt(fieldName);
                CommonValidation.validateNumberOutOfRangeException(value, fieldName, 0, 100);
                return value;
            } catch (Exception e) {
//                e.printStackTrace();
                System.err.println(e.getMessage());
                System.err.println("Vui lòng nhập lại");
            }
        }
    }

    public static String inputDescription(String fieldName) {
        while (true) {
            try {
                String description = inputString(fieldName);
                CommonValidation.validateMinLength(description, fieldName, 10);
                return description;
            } catch (Exception e) {
//                e.printStackTrace();
                System.err.println(e.getMessage());
                System.err.println("Vui lòng nhập lại");
            }
        }
    }

    public static Integer inputQuantity(String fieldName) {
        return inputInt(fieldName);
    }
}