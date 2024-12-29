package ss4_inheritance.exercises.Ex1;

import utils.InputCommonV2;
import utils.enums.CheckInputLimit;

public class OldPhone extends Phone {
    private static int index = 0;
    private String batteryHealth;
    private String description;

    @Override
    public void display() {
        System.out.printf("| %-10s | %-20s | %-10.2f | %-10d | %-10s | %-10s | %-10s | %-10s |\n", getId(), getName(), getPrice(), getWarrantyYear(), getBrand(), null, batteryHealth, description);
    }

    @Override
    public void editInfo(InputCommonV2 ic) {
        System.out.println("----------------------");
        System.out.println("Input phone name: ");
        setName(ic.checkInputString());
        System.out.println("Input phone price: ");
        setPrice(ic.checkNumberInput(Double.class, CheckInputLimit.MIN, 0D));
        System.out.println("Input phone warranty year: ");
        setWarrantyYear(ic.checkNumberInput(Integer.class, CheckInputLimit.MIN, 0));
        System.out.println("Input phone brand: ");
        setBrand(ic.checkEnumInput(Brand.class));
        System.out.println("Input phone battery health: ");
        batteryHealth = ic.checkInputString();
        System.out.println("Input phone description: ");
        description = ic.checkInputString();
    }

    public OldPhone() {
        setId("DTC" + String.format("%03d", index++));
    }

    public OldPhone(String name, double price, int warrantyYear, Brand brand) {
        super(name, price, warrantyYear, brand);
        setId("DTC" + String.format("%03d", index++));
    }
}
