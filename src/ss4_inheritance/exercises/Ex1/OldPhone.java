package ss4_inheritance.exercises.Ex1;

import utils.InputCommonV2;

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
        super.editInfo(ic);
        System.out.print("Input phone battery health: ");
        batteryHealth = ic.checkInputString();
        System.out.print("Input phone description: ");
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
