package ss1_oop_overview.exercise1;


import utils.InputCommonV2;

public class MainEx1 {
    public static void main(String[] args) {
        Student student = new Student();
        try (InputCommonV2 ic = new InputCommonV2()) {
            student.input(ic);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        student.output();
    }
}
