package HomeWork7_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class EasySearchMain implements ISearchEngine {
    public static void main(String[] args) throws IOException {
        String fileContent = "";
        String[] words = {"война", "и", "мир"};
        Path fileName = Path.of("Война и мир_книга.txt");
        String[] variWord = new String[8];
        int sum = 0, localSum = 0;

        fileContent = Files.readString(fileName);
        EasySearch engine = new EasySearch();

        for (String word : words) {
            sum = 0;
            variWord = engine.arrOfWords(word);
            for (String s : variWord) {
                localSum = engine.search(fileContent, s);
                sum += localSum;
                System.out.println("В тексте слово \"" + s + "\" встречается " + localSum + " раз.");
            }
            System.out.println("Всего: " + sum + " раз.");
        }
    }
}
