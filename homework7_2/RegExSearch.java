package HomeWork7_2;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExSearch implements ISearchEngine {

    public int search(String resource, String word) {
        int count = 0;

        String firstSimsol = String.valueOf(word.charAt(0));
        word = word.substring(1, word.length());
        Pattern pattern = Pattern.compile("(\\s|[-.?!)(,:\"])" + "[" + firstSimsol.toLowerCase() + "|" + firstSimsol.toUpperCase() + "]" + word + "(\\s|[-.?!)(,:\"])");
        Matcher matcher = pattern.matcher(resource);

        while (matcher.find()) {
            count++;
        }
        return count;
    }
}
