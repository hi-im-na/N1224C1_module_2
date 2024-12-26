package ss1_oop_overview.exercise2;

import utils.InputCommon;

public class MainEx2 {
    public static void main(String[] args) {
        Fraction fraction = new Fraction();
        try (InputCommon ic = new InputCommon()) {
            fraction.input(ic);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        fraction.output();


        System.out.println(" ===================== ");
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(3, 4);

        System.out.println("Test with 2 fractions f1 = 1/2 and f2 = 3/4");
        Fraction f3 = f1.add(f2);
        System.out.print("Sum of 2 fractions: ");
        f3.output();

        Fraction f4 = f1.subtract(f2);
        System.out.print("Subtract of 2 fractions: ");
        f4.output();

        Fraction f5 = f1.multiply(f2);
        System.out.print("Multiply of 2 fractions: ");
        f5.output();

        Fraction f6 = f1.divide(f2);
        System.out.print("Divide of 2 fractions: ");
        f6.output();

        System.out.print("Check yin yang of fraction f1 (input): ");
        fraction.checkYinYang();
    }
}
