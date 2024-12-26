package ss1_oop_overview.practice;

import java.util.Scanner;

class Student {
    int id;
    String name;
    double score;

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student id: ");
        id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter student name: ");
        name = scanner.nextLine();
        System.out.println("Enter student score: ");
        score = Double.parseDouble(scanner.nextLine());
        scanner.close();
    }

    public void display() {
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
