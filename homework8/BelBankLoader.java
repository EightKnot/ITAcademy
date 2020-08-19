package HomeWork8;

public class BelBankLoader extends SiteLoader {

    /**
     * Метод для запуска загрузки курса валют
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    public double load(SiteLoader.Currency currencyName) {
        return load("https://belarusbank.by/api/kursExchange/" + currencyName.getId(), currencyName);
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
        int indexOfRate = content.indexOf(currencyName.toString().concat("_in")) + 9;
        inRate = Double.parseDouble(content.substring(indexOfRate, indexOfRate + 4));
        indexOfRate = content.indexOf(currencyName.toString().concat("_out")) + 10;
        outRate = Double.parseDouble(content.substring(indexOfRate, indexOfRate + 4));
        return  inRate + outRate/1000;
    }
}
