package ss1_oop_overview.practice;

import utils.InputCommonV2;
import utils.enums.CheckInputLimit;

import java.util.ArrayList;
import java.util.List;

class StudentManagement {
    public static void main(String[] args) {
        try (InputCommonV2 ic = new InputCommonV2()) {
            System.out.print("Nhap so sinh vien muon nhap: ");
            int n = ic.checkNumberInput(Integer.class, CheckInputLimit.MIN, 1);

            List<Student> studentList = new ArrayList<>();
            Student student;
            for (int i = 0; i < n; i++) {
                student = new Student();
                student.input(ic);
                studentList.add(student);
            }

            for (Student s : studentList) {
                s.display();
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
