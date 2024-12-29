package ss3_static.exercise.Ex1;

class Student {
    private int id;
    private String name;
    double score;
    static int count = 0;

    public Student() {
        Student.count++;
    }
}
