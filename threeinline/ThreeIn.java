package ThreeInLine;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ThreeIn {
    public static void main(String[] args) throws IOException, URISyntaxException {


        Field f1 = new Field();
        f1.draw();
    /*    System.out.println("Введите координаты цифры через запятую и направление после пробела, в котором ее сместить:");
        f1.move();
        f1.fieldIncr();
        f1.analyze();
        f1.draw();*/

        Save.save(f1);

    }



}