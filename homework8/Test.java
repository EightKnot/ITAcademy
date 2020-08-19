package HomeWork8;

import java.util.Date;

public class Test {

    public static void main(String[] args) {
        printRates(new NBRBLoader());
        printRates(new BelBankLoader(), "Belarusbank");
        printRates(new AlphaBankLoader(), "Alphabank");
        printRatesAlt(new BPSBankLoader(), "BPSBank");
        printRatesAlt(new BelAgroBankLoader(), "BelAgroBank");
    }

    public static void printRates(SiteLoader loader) {
        Date date = new Date();
        System.out.println("Курс EUR в НБРБ на " + date + ": " + loader.load(SiteLoader.Currency.EUR));
        System.out.println("Курс RUB в НБРБ на " + date + ": " + loader.load(SiteLoader.Currency.RUB));
        System.out.println("Курс USD в НБРБ на " + date + ": " + loader.load(SiteLoader.Currency.USD));
    }

    /**
     * С помощью метода load получаем переменную типа double, хранящую в себе
     * два значения: курс покупки валюты и курс продажи
     * @param loader объект класса SiteLoader (в нашем случае дочернии)
     * @param bankName название банка, к которому обращаемся
     */
    public static void printRates(SiteLoader loader, String bankName) {
        Date date = new Date();

        for (SiteLoader.Currency currency : SiteLoader.Currency.values()) { // forEach для перечисления Enum, хранящего названия валют
            double inOutRates = loader.load(currency);
            double inRate = Math.floor(inOutRates * 100) / 100; // получаем ("отделяем") значение курса покупки

            inOutRates -= inRate;
            inOutRates = (double) Math.round(inOutRates * 100000) / 100; // получаем ("отделяем") значение курса продажи
            System.out.println("Курс " + currency + " в банке " + bankName + " на " + date + ": " +
                    "покупка " + inRate + "/ " + " продажа " + inOutRates);
        }
    }

    public static void printRatesAlt(SiteLoader loader, String bankName) {
        Date date = new Date();

        for (SiteLoader.Currency currency : SiteLoader.Currency.values()) { // forEach для перечисления Enum, хранящего названия валют
            loader.load(currency);
            System.out.println("Курс " + currency + " в банке " + bankName + " на " + date + ": " +
                    "покупка " + loader.getRateIn() + "/ " + " продажа " + loader.getRateOut());
        }
    }
}
