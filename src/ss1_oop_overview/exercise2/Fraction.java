package ss1_oop_overview.exercise2;

import utils.InputCommon;
import utils.MathSolve;

import java.util.List;

public class Fraction {
    /**
     * tử số
     */
    private int numerator;

    /**
     * mẫu số
     */
    private int denominator;

    public void input(InputCommon ic) {
        System.out.print("Nhap tu so: ");
        numerator = ic.checkInputInt();
        System.out.print("Nhap mau so: ");
        denominator = ic.checkInputInt(Integer.MIN_VALUE, Integer.MAX_VALUE, List.of(0));

        //rut gon phan so
        Fraction f = reduce(this);

        this.numerator = f.numerator;
        this.denominator = f.denominator;
    }

    public void output() {
        System.out.println(numerator + "/" + denominator);
    }

    public Fraction reduce(Fraction f) {
        // dua dau am len tu so
        if (f.denominator < 0) {
            f.numerator *= -1;
            f.denominator *= -1;
        }

        int gcd = MathSolve.gcd(f.numerator, f.denominator);
        f.numerator /= gcd;
        f.denominator /= gcd;
        return f;
    }

    public Fraction add(Fraction f) {
        Fraction result = new Fraction();
        result.numerator = numerator * f.denominator + f.numerator * denominator;
        result.denominator = denominator * f.denominator;
        return reduce(result);
    }

    public Fraction subtract(Fraction f) {
        Fraction result = new Fraction();
        result.numerator = numerator * f.denominator - f.numerator * denominator;
        result.denominator = denominator * f.denominator;
        return reduce(result);
    }

    public Fraction multiply(Fraction f) {
        Fraction result = new Fraction();
        result.numerator = numerator * f.numerator;
        result.denominator = denominator * f.denominator;
        return reduce(result);
    }

    public Fraction divide(Fraction f) {
        Fraction result = new Fraction();
        result.numerator = numerator * f.denominator;
        result.denominator = denominator * f.numerator;
        return reduce(result);
    }

    public void checkYinYang() {
        int result = Integer.compare(numerator * denominator, 0);
        if (result == 0) {
            System.out.println("Phan so bang 0");
        } else if (result > 0) {
            System.out.println("Phan so duong");
        } else {
            System.out.println("Phan so am");
        }
    }

    public Fraction() {
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }
}
