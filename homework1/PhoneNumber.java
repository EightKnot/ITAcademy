package HomeWork1;

import java.util.Scanner;

public class PhoneNumber {
    public static String createPhoneNumber (String number) {
        if (number.length() <10 || number.length() >10)
            return "оБшиБка! Введенный номер не десятизначный.";

        char[] s = new char[10];
        for (int i = 0; i < 10; i++)
            s[i] = number.charAt(i);

        String str = "(";

        for (int i = 0; i < 3; i++)
            str += s[i];

        str += ") ";

        for (int i = 3; i < 6; i++)
            str += s[i];

        str += "-";

        for (int i = 6; i < 10; i++)
            str += s[i];

        return str;
    /*  Второй вариант (оптимизированный):
        for (int i = 0; i < 10; i++) {
            if (i == 3)
                str += ") ";
            if (i == 6)
                str += "-";
            str += s[i];
        }
        return str;
     */
    }
    public static void main (String[] args) {
        System.out.println("Введите номер телефона (10 знаков):");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(createPhoneNumber(s));
    }
}
