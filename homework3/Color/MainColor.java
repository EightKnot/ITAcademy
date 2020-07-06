package HomeWork3.Color;

import java.util.Scanner;

public class MainColor {
    public static void main(String[] args) {
        Color color;
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("Введите номер цвета:");
            color = new Color(in.nextInt());
            System.out.println("Название цвета №" + color.getNumber() + ": " + color.getName());
        } while (color.getName() != "Неизвестно");
    }
}
