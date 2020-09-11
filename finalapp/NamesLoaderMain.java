package FinalApp;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;

public class NamesLoaderMain {
    public static void main(String[] args) {
        HashSet<String> nameList = new HashSet<>();
        NamesLoader namesLoader = new NamesLoader();
        for (int i = 5; i < 15; i++) {
            nameList.addAll(namesLoader.load("https://igra.evroopt.by/archive/listmembers/?page=" + i));
        }
        try {
            Writer writer = new FileWriter("NameList.txt");
            for (String s : nameList) {
                writer.write(s + "\n");
            }
            writer.flush();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
