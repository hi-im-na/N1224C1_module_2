package ss3_static.exercise.Ex3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateUtil {
    public static LocalDate fromString_ddMMyyyy(String str) {
        return LocalDate.parse(str, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public static LocalDate fromString_yyyyMMdd(String str) {
        return LocalDate.parse(str, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }

    public static String toString_ddMMyyyy(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public static String toString_yyyyMMdd(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }
}
