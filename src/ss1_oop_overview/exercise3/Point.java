package ss1_oop_overview.exercise3;

import utils.InputCommonV2;

public class Point {
    private int x;
    private int y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void input(InputCommonV2 ic) {
        System.out.print("Enter x: ");
        x = ic.checkNumberInput(Integer.class);
        System.out.print("Enter y: ");
        y = ic.checkNumberInput(Integer.class);
    }

    public void display() {
        System.out.printf("Point: (%d, %d)\n", x, y);
    }

    public double distanceTo(Point point) {
        return Math.sqrt(Math.pow(x - point.x, 2) + Math.pow(y - point.y, 2));
    }
}
