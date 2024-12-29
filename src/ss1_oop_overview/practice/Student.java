package ss1_oop_overview.practice;

import utils.InputCommonV2;
import utils.enums.CheckInputLimit;

class Student {
    int id;
    String name;
    double score;

    public void input(InputCommonV2 ic) {
        System.out.println(" ===================== ");
        System.out.print("Enter student id: ");
        id = ic.checkNumberInput(Integer.class, CheckInputLimit.MIN, 1);
        System.out.print("Enter student name: ");
        name = ic.checkInputString();
        System.out.print("Enter student score: ");
        score = ic.checkNumberInput(Double.class, CheckInputLimit.MIN, 0D);
    }

    public void display() {
        System.out.println(" ===================== ");
        System.out.println("Student id: " + id);
        System.out.println("Student name: " + name);
        System.out.println("Student score: " + score);
    }

    public Student() {
    }

    public Student(int id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
