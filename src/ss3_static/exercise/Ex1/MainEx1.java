package ss3_static.exercise.Ex1;

public class MainEx1 {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Student student = new Student();
        }

        System.out.println(Student.count);
    }
}
