package ss1_oop_overview.exercise1;

import java.util.Scanner;

class Student {
    String name;
    double mathScore;
    double literatureScore;

    void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student name: ");
        name = scanner.nextLine();
        System.out.println("Enter math score: ");
        mathScore = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter literature score: ");
        literatureScore = Double.parseDouble(scanner.nextLine());
        scanner.close();
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
