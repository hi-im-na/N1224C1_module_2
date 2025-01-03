package ss4_inheritance.exercises.Ex1;

import utils.InputCommonV2;
import utils.enums.CheckInputLimit;

public class NewPhone extends Phone {
    private static int index = 0;
    private int quantity;

    @Override
    public void display() {
        System.out.printf("| %-10s | %-20s | %-10.2f | %-10d | %-10s | %-10d | %-10s | %-10s |\n", getId(), getName(), getPrice(), getWarrantyYear(), getBrand(), quantity, null, null);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * quantity;
    }

    @Override
    public void editInfo(InputCommonV2 ic) {
        super.editInfo(ic);
        System.out.print("Input phone quantity: ");
        quantity = ic.checkNumberInput(Integer.class, CheckInputLimit.MIN, 1);
    }

    public NewPhone() {
        setId("DTM" + String.format("%03d", index++));
    }

    public NewPhone(String name, double price, int warrantyYear, Brand brand) {
        super(name, price, warrantyYear, brand);
        setId("DTM" + String.format("%03d", index++));
    }

    public static int getIndex() {
        return index;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
