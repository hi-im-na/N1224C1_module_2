package ss4_inheritance.exercises.Ex1;

import utils.InputCommonV2;
import utils.enums.CheckInputLimit;

public abstract class Phone {

    public enum Brand {
        SAMSUNG, IPHONE
    }

    private String id;
    private String name;
    private double price;
    private int warrantyYear;
    private Brand brand;

    public abstract void display();

    public abstract double calculateTotalPrice();

    public void editInfo(InputCommonV2 ic) {
        System.out.println("----------------------");
        System.out.print("Input phone name: ");
        setName(ic.checkInputString());
        System.out.print("Input phone price: ");
        setPrice(ic.checkNumberInput(Double.class, CheckInputLimit.MIN, 0D));
        System.out.print("Input phone warranty year: ");
        setWarrantyYear(ic.checkNumberInput(Integer.class, CheckInputLimit.MIN, 0));
        System.out.print("Input phone brand: ");
        setBrand(ic.checkEnumInput(Brand.class));
    }

    public Phone() {
    }

    public Phone(String name, double price, int warrantyYear, Brand brand) {
        this.name = name;
        this.price = price;
        this.warrantyYear = warrantyYear;
        this.brand = brand;
    }

    public Phone(String id, String name, double price, int warrantyYear, Brand brand) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.warrantyYear = warrantyYear;
        this.brand = brand;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getWarrantyYear() {
        return warrantyYear;
    }

    public void setWarrantyYear(int warrantyYear) {
        this.warrantyYear = warrantyYear;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}

