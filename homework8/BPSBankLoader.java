package HomeWork8;

public class BPSBankLoader extends SiteLoader {
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
        return load("https://www.bps-sberbank.by/page/currency-exchange-cards/", currencyName);
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
        if (currencyName.toString() == "RUB") {
            indexOfRate = content.indexOf("100 ".concat(currencyName.toString()));
            rateIn = Double.parseDouble(content.substring(indexOfRate + 49, indexOfRate + 50)) + Double.parseDouble(content.substring(indexOfRate + 51, indexOfRate + 53)) / 100;
            rateOut = Double.parseDouble(content.substring(indexOfRate + 68, indexOfRate + 69)) + Double.parseDouble(content.substring(indexOfRate + 70, indexOfRate + 72)) / 100;
        } else {
            indexOfRate = content.indexOf("1 ".concat(currencyName.toString()));
            rateIn = Double.parseDouble(content.substring(indexOfRate + 47, indexOfRate + 48)) + Double.parseDouble(content.substring(indexOfRate + 49, indexOfRate + 51)) / 100;
            rateOut = Double.parseDouble(content.substring(indexOfRate + 66, indexOfRate + 67)) + Double.parseDouble(content.substring(indexOfRate + 68, indexOfRate + 70)) / 100;
        }
//        indexOfRate = content.indexOf(currencyName.toString().concat("_out")) + 10;
//        outRate = Double.parseDouble(content.substring(indexOfRate, indexOfRate + 4));
        return  0;
    }
}
