package ThreeInLine;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Load {
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

/*        FileReader reader = new FileReader("homework/src/threeinline/" + fileName);
        try
        {
            System.out.println(reader.);
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
*/

    }
}
