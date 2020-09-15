package GDACSApp;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Test {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        String formattedDate = today.format(DateTimeFormatter.ofPattern("dd MMM", Locale.ENGLISH));
        System.out.println("Current date: " + formattedDate);
        System.out.println(new GDACSLoader().load(""));
        Toolkit.getDefaultToolkit().beep();
        System.out.print("AAA");
        System.out.print("\7");
        System.out.println("BBB");


        Country country = new Country();

//        System.out.println(country.toString());
//        country.load("https://api6.ipify.org/?format=json");
//        System.out.println(country.toString());
//        System.out.println(country.ip); //
//        country.load("https://geo.ipify.org/api/v1?apiKey=at_0tP7qAps0Uis1wLDo3mGPVL47rhXS&ipAddress=" + country.ip);
    }
}
