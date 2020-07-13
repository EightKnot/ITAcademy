package ThreeInLine;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

public class Save {
    public static String fileName = "Saves.txt";
    public static void save(Field f1) throws IOException {
        File savesFile = new File("homework//src//threeinline", fileName);
        try
        {
            boolean created = savesFile.createNewFile();
            if(created)
                System.out.println("File " + fileName + " has been created");
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }

        FileWriter writer = new FileWriter("homework/src/threeinline/" + fileName, false);
        try
        {
            writer.write(Integer.toString(35));
            writer.write("ghj");
            for (int i = 0; i < f1.getArrLengthY(); i++) {
                writer.write("\n");
                for (int j = 0; j < f1.getArrLengthX(i); j++) {
                    writer.write(Integer.toString(f1.getField(i, j)) + " ");
                }

            }

            writer.close();

        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }


    }
}
