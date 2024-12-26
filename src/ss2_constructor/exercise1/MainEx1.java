package ss2_constructor.exercise1;

import ss1_oop_overview.exercise2.Fraction;

public class MainEx1 {
    public static void main(String[] args) {
        Fraction f1 = new Fraction();
        f1.output();
        Fraction f2 = new Fraction(1, 2);
        f2.output();

        Fraction f3 = new Fraction(3);
        f3.output();

        Fraction f4 = new Fraction(-6, -2);
        f4.output();

        Fraction f5 = new Fraction(3, -1);
        f5.output();

        Fraction f6 = f5.copy();
        f6.add(100);
        f5.output();
        f6.output();
    }
}
