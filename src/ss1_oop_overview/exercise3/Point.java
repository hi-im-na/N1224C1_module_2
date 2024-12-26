package ss1_oop_overview.exercise3;

import utils.InputCommon;

public class Point {
    private int x;
    private int y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void input(InputCommon ic) {
        System.out.print("Enter x: ");
        x = ic.checkInputInt();
        System.out.print("Enter y: ");
        y = ic.checkInputInt();
    }

    public void display() {
        System.out.printf("Point: (%d, %d)\n", x, y);
    }

    public double distanceTo(Point point) {
        return Math.sqrt(Math.pow(x - point.x, 2) + Math.pow(y - point.y, 2));
    }
}
