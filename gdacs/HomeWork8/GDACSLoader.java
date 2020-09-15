package GDACS.HomeWork8;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class GDACSLoader extends SiteLoader {

    /**
     * Метод для загрузки информации с сайта GDACS
     * @param country название страны
     * @return переменную String, хранящую в себе ссылку на информацию с сайта в памяти
     */
    @Override
    public String load(String country) {
        return load("https://www.gdacs.org/", country);
    }

    /**
     * Обработка результата загрузки с сайта GDACS (поиск и передача актуальных предупреждений о ЧС)
     * @param content ссылка на загруженную информацию
     * @param country название страны
     * @return сформированную строку, хранящую в себе информацию для вывода в консоль
     */
    @Override
    protected String handle(String content, String country) {
        String contGDACS = ""; // информация для вывода в консоль

        LocalDateTime currDate = LocalDateTime.now();
        String dayFormat = currDate.format(DateTimeFormatter.ofPattern("dd", Locale.ENGLISH));
        String monthFormat = currDate.format(DateTimeFormatter.ofPattern("MMM", Locale.ENGLISH));
        String timeFormat = currDate.format(DateTimeFormatter.ofPattern("hh:mm", Locale.ENGLISH));


        contGDACS = ("за дежурные сутки поступили предупреждения:\nо землетрясениях ");
        /**
         * Earthquakes
         */
        contGDACS = contGDACS.concat(infoExtractor("Earthquakes","Tropical cyclones", content, monthFormat, dayFormat));

        /**
         * Tropical cyclones
         */
        contGDACS = contGDACS.concat("о тропических циклонах ");
        contGDACS = contGDACS.concat(infoExtractor("Tropical cyclones","Floods", content, monthFormat, dayFormat));

        /**
         * Floods
         */
        contGDACS = contGDACS.concat("о наводнениях ");
        contGDACS = contGDACS.concat(infoExtractor("Floods","Volcanoes", content, monthFormat, dayFormat));

        return  contGDACS;
    }

    /**
     * Метод обработки полученной с сайты GDACS информации
     * @param textFrom определяет от какого ключевого слова осуществлять поиск
     * @param textTo определяет до какого ключевого слова осуществлять поиск
     * @param content ссылка наполученную с сайта информацию
     * @param monthFormat формат месяца
     * @param dayFormat формат числа месяца
     * @return строку с обработанной информацией для передачи в консоль
     */
    public String infoExtractor(String textFrom, String textTo, String content, String monthFormat, String dayFormat) {
        int indexOfSrt = content.indexOf(textFrom); // Адрес текущего положения каретки при поиске (чтобы повторно не производить поиск в проверенном блоке0
        String[] date = new String[3]; // для обработки даты/времени, полученных с сайта в виде строки
        String contGDACS = ""; // полученная информация о текущей разновидности предупреждений
        String name = ""; // Название страны/имя тропического циклона
        String magnitude = ""; // Магнитуда колебаний/скорость ветра/""
        String alertDate = ""; // Дата предупреждения (с указанием времени в недавних предупреждениях)


        while ((indexOfSrt = content.indexOf("alert_item_name\"", indexOfSrt)) < content.indexOf(textTo, content.indexOf(textFrom))) { // определяет блок текста для поиска
            name = content.substring(indexOfSrt + 17, content.indexOf(60, indexOfSrt)); // 17 == "alert_item_name\"".length
            /**
             * В случаях земетрясений и наводнений переводим название страны
             */
            if (textFrom.compareTo("Earthquakes") == 0 || textFrom.compareTo("Floods") == 0) {
                String tempName = name.replaceAll("\\s", "_"); // приводим к формату, понятному Wiki
                CountryTranslater countryTranslater = new CountryTranslater();
//                name = tempName = "Заглавная_11111"; // для теста
                tempName = countryTranslater.load(tempName);
                if (tempName.compareTo("FnF") != 0) {
                    name = tempName;
                } else {
                    name = name.concat(" (На Wiki нет информации)");
                }
            }
            indexOfSrt = content.indexOf("magnitude", indexOfSrt);
            indexOfSrt = content.indexOf(40, indexOfSrt); // ближайшая открывающаяся скобка
            magnitude = content.substring(indexOfSrt, content.indexOf(41, indexOfSrt) + 1); // до закрывающейся скобки

            /**
             * В случае тропических циклонов, меняем единицу измерения
             */
            if (textFrom.compareTo("Tropical cyclones") == 0) {
                magnitude = magnitude.substring(0, magnitude.indexOf("km/")).concat("км/ч)");
            }

            indexOfSrt = content.indexOf("alert_date", indexOfSrt);
            indexOfSrt = content.indexOf(45, indexOfSrt);
            date = content.substring(indexOfSrt + 1, content.indexOf(60, indexOfSrt)).split(" +");

            /**
             * Если есть информация о времени предупреждения
             */
            if (date.length > 3) {
                date[3] = date[3].substring(1); // .strip(); //.substring(1);
            }

            alertDate = date[1].concat(" ").concat(date[2].trim()).concat(" ");
            if (date.length > 3) { // если есть информация о времени
                alertDate = alertDate.concat(date[3].trim());
            }
            /**
             * Фильтр за дежурные сутки
             */
            if (date[2].trim().equals(monthFormat) &&
                    (date[1].equals(dayFormat) ||
                            (Integer.parseInt(date[1]) == Integer.parseInt(dayFormat) - 1) &&
                                    (date[3].compareTo("06:00") > 0))) {
                contGDACS = contGDACS.concat(name + magnitude + " " + alertDate + ", \n");
            } else {
                break;
            }
        }
        /**
         * Формирование ответа в случае отсутствия результатов, удовлетворяющих условиям
         */
        if (contGDACS.length() == 0) {
            switch (textFrom) {
                case "Earthquakes":
                    return "не поступало,\n";
                case "Tropical cyclones":
                    return "не поступало,\n";
                case "Floods":
                    return "не поступало";
            }
        }
        if (textFrom.compareTo("Tropical cyclones") != 0) {
            return "в\n".concat(contGDACS);
        }
        return "\n".concat(contGDACS);
    }
}
