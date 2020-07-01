package HomeWork2;

import java.util.Scanner;

public class Peramnoz {
    public static void main(String[] args) {
        int enter = Integer.parseInt(args[0]);
        int result = 1;
        for (int i = 1; i <= enter ; i++) {
            if (Integer.MAX_VALUE / result < i + 1) {
                System.out.println("перАбОр...");
                System.exit(0);
            }
            result *= i;
        }
        System.out.print("1");
        for (int i = 2; i <= enter; i++)
            System.out.print(" * " + i);
        System.out.println(" = " + result);

//  Версия с консольным вводом:
/*
        System.out.println("Введите число:");
        Scanner in = new Scanner(System.in);
        int enter = Integer.parseInt(in.nextLine());
        int result = 1;
        for (int i = 1; i <= enter ; i++) {
            if (Integer.MAX_VALUE / result < i + 1) {
                System.out.println("перАбОр...");
                System.exit(0);
            }
            result *= i;
        }
        System.out.print("1");
        for (int i = 2; i <= enter; i++)
            System.out.print(" * " + i);
        System.out.println(" = " + result);

 */
    }
}
