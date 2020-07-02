package HomeWork2;

import java.util.Scanner;

public class Exponent {
    public static void main(String[] args) {
        System.out.println("Введите число и, через пробел, степень, вкоторую его нужно возвести:");
        Scanner user = new Scanner(System.in);
        String userDig = user.nextLine();
        int indCh = userDig.indexOf(" ");
        int len = userDig.length();
        int dig = Integer.parseInt(userDig.substring(0, indCh));
        int exp = Integer.parseInt(userDig.substring(indCh + 1, len));
        System.out.println("Число " + dig + " в степени " + exp + " равно " + Math.pow(dig, exp));
//    }

    // Вариант по-проще:
    /*
        public static void main(String[] args) {
        System.out.println("Введите число, которое нужно возвести в степень:");
        Scanner user = new Scanner(System.in);
        int dig = user.nextInt();
        System.out.println("Введите степень, в которую нужно возвести число:");
        int exp = user.nextInt();
        System.out.println("Число " + dig + " в степени " + exp + " равно " + Math.pow(dig, exp));
    */
    }
}
