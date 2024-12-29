package ss4_inheritance.exercises.Ex1;

import utils.InputCommonV2;

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

    public abstract void editInfo(InputCommonV2 ic);

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

