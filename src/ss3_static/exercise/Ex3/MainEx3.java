package ss3_static.exercise.Ex3;

import java.time.LocalDate;

public class MainEx3 {
    public static void main(String[] args) {
        System.out.println(LocalDateUtil.fromString_ddMMyyyy("02/01/2000"));
        System.out.println(LocalDateUtil.fromString_yyyyMMdd("2000/01/03"));
        System.out.println(LocalDateUtil.toString_ddMMyyyy(LocalDate.of(2000, 12, 21)));
        System.out.println(LocalDateUtil.toString_yyyyMMdd(LocalDate.of(2000, 12, 20)));
    }
}
