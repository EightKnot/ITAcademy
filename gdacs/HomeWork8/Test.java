package GDACS.HomeWork8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Test {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        String formattedDate = today.format(DateTimeFormatter.ofPattern("dd MMM", Locale.ENGLISH));
        System.out.println("Current date: " + formattedDate);
        System.out.println(new GDACSLoader().load(""));
    }
}
