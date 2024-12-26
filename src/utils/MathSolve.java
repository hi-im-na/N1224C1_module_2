package utils;

public class MathSolve {
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    /**
     * Calculate the greatest common divisor of two numbers even if they are negative
     *
     * @param a the first number
     * @param b the second number
     * @return the greatest common divisor of a and b
     */
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0) return b;
        if (b == 0) return a;
        if (a == b) return a;
        if (a > b) return gcd(a - b, b);
        return gcd(a, b - a);
    }
}
