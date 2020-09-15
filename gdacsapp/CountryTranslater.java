package GDACS.HomeWork8;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CountryTranslater extends SiteLoader {

    /**
     * Метод для получения русского перевода названия страны
     * @param country страна, название которой нужно перевести
     * @return перевод либо "FnF" в случае возникновения ошибки FileNotFoundException
     * при обращении к несуществующей странице Wiki
     */
    @Override
    public String load(String country) {
        return load("https://ru.wikipedia.org/wiki/" + country, country);
    }

    /**
     * Обработка результата загрузки с сайта Wiki (поиск и передача заголовка страницы)
     * @param content то что получилось загрузить
     * @param country название страны
     * @return заголовок страници (название страны на русском)
     */
    @Override
    protected String handle(String content, String country) {
        String contGDACS = "";
        int indexOfSrt = 0;

        indexOfSrt = content.indexOf("wgTitle");
        indexOfSrt += 10;
        contGDACS = content.substring(indexOfSrt, content.indexOf(34, indexOfSrt));

        return contGDACS;
    }
}
