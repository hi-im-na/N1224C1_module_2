package ss2_constructor.exercise2;

public class MainEx2 {
    public static void main(String[] args) {
        Time a = new Time();
        a.output();
        Time b = new Time(7);
        b.output();
        Time c = new Time(7, 30);
        c.output();
        Time d = new Time(7, 30, 50);
        d.output();
        Time e = new Time(d);
        e.output();
    }
}
