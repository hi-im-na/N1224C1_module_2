package ss10_exception.excercises.validation;

import java.util.Scanner;

public class PhoneValidation {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputName(String fieldName) {
        while (true) {
            try {
                System.out.println("Nhập vào " + fieldName + ": ");
                String name = scanner.nextLine();

                CommonValidation.validateIsEmpty(name, fieldName);

                return name;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                System.out.println("Vui lòng nhập lại");
            }
        }
    }

    public static double inputPrice(String fieldName) {
        while (true) {
            try {
                System.out.println("Nhập vào " + fieldName + ": ");
                String price = scanner.nextLine();

                CommonValidation.validateIsEmpty(price, fieldName);
                double priceDouble = CommonValidation.parseDouble(price, fieldName);
                CommonValidation.validateIsNegativeNumber(priceDouble, fieldName);

                return priceDouble;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                System.out.println("Vui lòng nhập lại");
            }
        }
    }

    public static int inputWarranty(String fieldName) {
        while (true) {
            try {
                System.out.println("Nhập vào " + fieldName + ": ");
                String warranty = scanner.nextLine();

                CommonValidation.validateIsEmpty(warranty, fieldName);
                int warrantyInt = CommonValidation.parseInt(warranty, fieldName);
                CommonValidation.validateIsNegativeNumber(warrantyInt, fieldName);

                return warrantyInt;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                System.out.println("Vui lòng nhập lại");
            }
        }
    }

    public static String inputManufacturer(String fieldName) {
        while (true) {
            try {
                System.out.println("Nhập vào " + fieldName + ": ");
                String manufacturer = scanner.nextLine();

                CommonValidation.validateIsEmpty(manufacturer, fieldName);

                return manufacturer;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                System.out.println("Vui lòng nhập lại");
            }
        }
    }

    public static Integer inputBatteryPercentage(String fieldName) {
        while (true) {
            try {
                System.out.println("Nhập vào " + fieldName + ": ");
                String batteryPercentage = scanner.nextLine();

                CommonValidation.validateIsEmpty(batteryPercentage, fieldName);
                int batteryPercentageInt = CommonValidation.parseInt(batteryPercentage, fieldName);
                CommonValidation.validateNumberOutOfRangeException(batteryPercentageInt, fieldName, 0, 100);

                return batteryPercentageInt;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                System.out.println("Vui lòng nhập lại");
            }
        }
    }

    public static String inputDescription(String fieldName) {
        while (true) {
            try {
                System.out.println("Nhập vào " + fieldName + ": ");
                String description = scanner.nextLine();

                CommonValidation.validateIsEmpty(description, fieldName);
                CommonValidation.validateMinLength(description, fieldName, 10);

                return description;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                System.out.println("Vui lòng nhập lại");
            }
        }
    }

    public static Integer inputQuantity(String fieldName) {
        while (true) {
            try {
                System.out.println("Nhập vào " + fieldName + ": ");
                String quantity = scanner.nextLine();

                CommonValidation.validateIsEmpty(quantity, fieldName);
                int quantityInt = CommonValidation.parseInt(quantity, fieldName);
                CommonValidation.validateIsNegativeNumber(quantityInt, fieldName);

                return quantityInt;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                System.out.println("Vui lòng nhập lại");
            }
        }
    }

}
