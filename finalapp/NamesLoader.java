package FinalApp;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Реализация загрузчика ФИО с сайта
 */
public class NamesLoader {

    /**
     * Метод для запуска загрузки ФИО с сайта
     * @param urlToSite урл по которому надо постучаться
     * @return курс который мы нашли
     */
    protected final HashSet load(String urlToSite){

        StringBuilder content;
        boolean error;
        int retryCount = 0;
        do{
            content = new StringBuilder();
            error = false;
            try {
                // create a url object
                HttpURLConnection con = (HttpURLConnection) new URL(urlToSite).openConnection();

                con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:47.0) Gecko/20100101 Firefox/47.0");
                con.setConnectTimeout(50000); //set timeout to 50 seconds
                con.setReadTimeout(50000); //set timeout to 50 seconds

                try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"))){
                    String line;
                    while ((line = bufferedReader.readLine()) != null)
                    {
                        content.append(line).append("\n");
                    }
                }
            }
            catch (FileNotFoundException e) {
                System.out.println(e);
            }
            catch(Exception e)
            {
                System.out.println(e);
                error = true;
                retryCount++;
                System.err.println("При соединении что-то пошло не так. "  + e.getMessage());
            }
        } while (error && retryCount < 5);

        if(error){
            throw new RuntimeException("Неполучилось загрузить данные");
        }
        return handle(content.toString());
    }

//    public abstract String load(String country);

    /**
     * Метод который будет дёрнут после успешной загрузки сайта
     * @param content содержимое сайта
     * @return список найденных ФИО
     */
    private HashSet<String> handle(String content) {
        Path fileName = Path.of("NameList.txt");
        String contNames = "";
        HashSet<String> nameList = new HashSet<String>();

        contNames = content.substring(content.indexOf("<table>"), content.indexOf("</table>"));

        Pattern pattern = Pattern.compile("[А-Я][а-я]+\\s[А-Я][а-я]+\\s[А-Я][а-я]+");
        Matcher matcher = pattern.matcher(contNames);
        while (matcher.find()) {
            nameList.add(matcher.group());
        }
//        System.out.println(nameList); // для отладки

        return nameList;
    }
}
