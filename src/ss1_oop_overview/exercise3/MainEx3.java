package ss1_oop_overview.exercise3;

import utils.InputCommonV2;

public class MainEx3 {
    public static void main(String[] args) {
        Point p1 = new Point();
        Point p2 = new Point();
        try (InputCommonV2 ic = new InputCommonV2()) {
            System.out.println("Enter two points p1 and p2:");
            p1.input(ic);
            p2.input(ic);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }


        System.out.printf("Distance between p1 and p2: %.2f", p1.distanceTo(p2));
    }
}
