package GDACSApp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CountryInfoAPI extends SiteLoader {

    /**
     * Метод для получения русского перевода названия страны
     * @param url страна, название которой нужно перевести
     * @return перевод либо "FnF" в случае возникновения ошибки FileNotFoundException
     * при обращении к несуществующей странице Wiki
     */
    @Override
    public String load(String url) {
        return load(url, "country");
    }

    /**
     * Обработка результата загрузки с сайта Wiki (поиск и передача заголовка страницы)
     * @param content то что получилось загрузить
     * @param country название страны
     * @return заголовок страници (название страны на русском)
     */
    @Override
    protected String handle(String content, String country) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        Country countryInfo = new Country();

        countryInfo = gson.fromJson(content,Country.class);

        System.out.println(countryInfo.toString());

        return "contGDACS";
    }
}
