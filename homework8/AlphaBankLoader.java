package HomeWork8;

public class AlphaBankLoader extends SiteLoader {
    /**
     * Метод для запуска загрузки курса валют
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    public double load(Currency currencyName) {
        return load("https://developerhub.alfabank.by:8273/partner/1.0.0/public/rates/", currencyName);
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
        int indexOfRate = content.indexOf(currencyName.toString());
        while (content.substring(indexOfRate - 30, indexOfRate - 22).compareTo("sellRate") != 0) {
            indexOfRate = content.indexOf(currencyName.toString(), ++indexOfRate);
        }
        inRate = Double.parseDouble(content.substring(indexOfRate - 20, indexOfRate - 16));
        outRate = Double.parseDouble(content.substring(indexOfRate + 30, indexOfRate + 34));
        return  inRate + outRate/1000;
    }
}
