package HomeWork8;

import java.util.Date;

public class Test {

    public static void main(String[] args) {
        printRates(new NBRBLoader());
    }

    public static void printRates(SiteLoader loader){
        Date date = new Date();
        System.out.println("Курс EUR на " + date + ": " + loader.load(SiteLoader.Currency.EUR));
        System.out.println("Курс RUB на " + date + ": " + loader.load(SiteLoader.Currency.RUB));
        System.out.println("Курс USD на " + date + ": " + loader.load(SiteLoader.Currency.USD));
    }
}
