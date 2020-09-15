package GDACSApp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Country extends SiteLoader{
    private String name;
    private String capital;
    private String population;
    private String area;
    public String ip;
    public String isp;
    public Location location;

    public Country() {
        Country.Location location = new Country.Location();
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    class Location {
        public String city;
        public String postalCode;
        public Location() {
        }
        public String getCity() {
            return city;
        }
        public void setCity(String city) {
            this.city = city;
        }

        @Override
        public String toString() {
            return "Location{" + "\n" +
                    "city=" + city + "\n" +
                    "postalCode='" + postalCode + "\n" +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Country{" + "\n" +
                "name=" + name + "\n" +
                "capital=" + capital + "\n" +
                "population=" + population + "\n" +
                "area=" + area + "\n" +
                "ip=" + ip + "\n" +
                "isp=" + isp + "\n" +
                "city=" + location.getCity() + "\n" +
//                "postalCode=" + location.postalCode + "\n" +
                '}';
    }

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
//    @Override
    protected String handle(String content, String country) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        Country countryInfo = new Country();

        countryInfo.getLocation().setCity("Lukinsk");
        countryInfo.setLocation(location);
        countryInfo = gson.fromJson(content,Country.class);
        countryInfo.location = gson.fromJson(content, Country.Location.class);
        System.out.println(countryInfo.location.getCity());

        this.ip = countryInfo.ip;
        System.out.println(countryInfo.toString());
//        System.out.println(location.getCity());

        return "contGDACS";
    }
}
