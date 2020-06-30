package HomeWork1;

import java.util.Scanner;

public class Peramnoz_2 {
    public static void main(String[] args) {
        String user = args[0];
        char[] s = new char[20];
        int summ = 1;
        for (int i = 0; i < user.length(); i++) {
            if (user.charAt(i) < '0' || user.charAt(i) > '9') {
                System.out.println("оБшиБка!!");
                return;
            }
            s[i] = user.charAt(i);
        }
        for (int i = 0; i < user.length(); i++) {
            System.out.print(s[i]);
            if (!(i > user.length() - 2))     // можно с do while
                System.out.print(" * ");
            summ *= (int) s[i] - (int) '0';
        }
        System.out.println(" = " + summ);

//  Версия с вводом с консоли:
/*
        System.out.println("Введите циферки, ни о чем при этом не думая:");
        Scanner in = new Scanner(System.in);
        String user = in.nextLine();
        char[] s = new char[20];
        int summ = 1;
        for (int i = 0; i < user.length(); i++) {
            if (user.charAt(i) < '0' || user.charAt(i) > '9') {
                System.out.println("оБшиБка!!");
                return;
            }
            s[i] = user.charAt(i);
        }
        for (int i = 0; i < user.length(); i++) {
            System.out.print(s[i]);
            if (!(i > user.length() - 2))     // можно с do while
                System.out.print(" * ");
            summ *= (int) s[i] - (int) '0';
        }
        System.out.println(" = " + summ);
*/
    }
}
