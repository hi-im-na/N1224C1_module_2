package ss1_oop_overview.exercise1;

import utils.InputCommon;

public class MainEx1 {
    public static void main(String[] args) {
        Student student = new Student();
        try (InputCommon ic = new InputCommon()) {
            student.input(ic);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        student.output();
    }
}
