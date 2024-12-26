package ss2_constructor.exercise3;

public class MainEx3 {
    public static void main(String[] args) {
        Student student = new Student(1, "John", 9.5);

        System.out.println("\nStudent info:");
        System.out.println("ID: " + student.getId());
        System.out.println("Name: " + student.getName());
        System.out.println("Score: " + student.getScore());

        // test set valid name and score
        student.setName("valid name");
        student.setScore(8.5);

        System.out.println("\nStudent info after set valid name and score:");
        System.out.println("ID: " + student.getId());
        System.out.println("Name: " + student.getName());
        System.out.println("Score: " + student.getScore());

        // test set invalid name and score
        student.setName("  ");
        student.setScore(11);
    }
}
