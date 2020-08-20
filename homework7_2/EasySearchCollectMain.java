package HomeWork7_2;

import HomeWork7.PersonPasswordAndNickComparator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public abstract class EasySearchCollectMain implements ISearchEngine {
    public static void main(String[] args) throws IOException {
        Path fileName = Path.of("Война и мир_книга.txt");
        String fileContent = Files.readString(fileName);

        String[] allWords = fileContent.split("\\s*(\\s|,|!|\\?|\"|;|:|--|\\d|\\(|\\)|\\*|\\.)\\s*");

        Map<String, Integer> sortWords = new HashMap<String, Integer>();

        for (String allWord : allWords) {
            if (sortWords.containsKey(allWord.toLowerCase()) && allWord.length() != 0)  {
                sortWords.put(allWord.toLowerCase(), sortWords.get(allWord.toLowerCase()) + 1);
            } else {
                sortWords.put(allWord.toLowerCase(), 1);
            }
        }

        Map<Integer, String> sortedWords = new TreeMap<>();
        int maxRepeats = 0;
        for (Map.Entry<String, Integer> sortWord : sortWords.entrySet()) {
            sortedWords.put(sortWord.getValue(), sortWord.getKey());
            if (sortWord.getValue().compareTo(maxRepeats) > 0) {
                maxRepeats = sortWord.getValue();
            }
        }
        for (int i = maxRepeats, j = 0; i > 0 && j < 10; i--) {
            if (sortedWords.containsKey(i)) {
                System.out.println("Слово \"" + sortedWords.get(i) + "\" встречается в тексте " + i + " раз");
                j++;
            }
        }
    }
}
