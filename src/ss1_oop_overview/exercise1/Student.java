package ss1_oop_overview.exercise1;

import utils.InputCommon;

class Student {
    String name;
    double mathScore;
    double literatureScore;

    void input(InputCommon ic) {
        System.out.println("Enter student name: ");
        name = ic.checkInputString();
        System.out.println("Enter math score: ");
        mathScore = ic.checkInputDouble();
        System.out.println("Enter literature score: ");
        literatureScore = ic.checkInputDouble();
    }

    public int calculateAverageScore() {
        return (int) ((mathScore + literatureScore) / 2);
    }

    public void output() {
        System.out.println("Student name: " + name);
        System.out.println("Math score: " + mathScore);
        System.out.println("Literature score: " + literatureScore);
        System.out.println("Average score: " + calculateAverageScore());
    }
}