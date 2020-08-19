package HomeWork8;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BelAgroBankLoader extends SiteLoader {
    double rateIn = 0;
    double rateOut = 0;

    public double getRateIn() {
        return rateIn;
    }

    public double getRateOut() {
        return rateOut;
    }

    /**
     * Метод для запуска загрузки курса валют
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    public double load(Currency currencyName) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        return load("https://belapb.by/ExCardsDaily.php?ondate=" + dateFormat.format(date), currencyName);
    }

    /**
     * Обработка результата загрузки с сайта банка
     * @param content то что получилось загрузить
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    protected double handle(String content, Currency currencyName) {
        double inRate = 0, outRate = 0;
        int indexOfRate = 0;

        indexOfRate = content.indexOf(currencyName.toString());
        indexOfRate = content.indexOf("RateBuy", indexOfRate) + "RateBuy>".length();
        rateIn = Double.parseDouble(content.substring(indexOfRate, indexOfRate + 4));

        indexOfRate = content.indexOf("RateSell", indexOfRate) + "RateSell>".length();
        rateOut = Double.parseDouble(content.substring(indexOfRate, indexOfRate + 4));

        return  0;
    }
}
