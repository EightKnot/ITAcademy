package HomeWork2;

import java.util.Scanner;

public class Exponent {
    private static Object Infinity;

    public static void main(String[] args) {
        System.out.println("Введите число и, через пробел, степень, в которую его нужно возвести:");
        Scanner user = new Scanner(System.in);
        String userDig = user.nextLine();
        int indCh = userDig.indexOf(" ");
        int len = userDig.length();
        int dig = Integer.parseInt(userDig.substring(0, indCh));
        int exp = Integer.parseInt(userDig.substring(indCh + 1, len));
        System.out.println("Число " + dig + " в степени " + exp + " равно " + Math.pow(dig, exp));

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

    // Вариант после вебинара
        System.out.println("Введите число и, через пробел, степень, в которую его нужно возвести:");
        userDig = user.nextLine();
        indCh = userDig.indexOf(" ");
        len = userDig.length();
        double digits = 0;
        double expo = 0;
        double result = 0;
        try {
            digits = Double.parseDouble(userDig.substring(0, indCh));
            expo = Double.parseDouble(userDig.substring(indCh + 1, len));
            result = Math.pow(digits, expo);
        }
        catch (NumberFormatException zu) {
            System.out.println("Веденные данные не соответствыуют типу double...");
            return;
        }
        catch (ArithmeticException e) {
            System.out.println("Произведено недопустимое арифметическое действие...\n" + e.getMessage());
        }
        if (Double.isInfinite(result))
            System.out.println("Произошло переполнение типа double...");
        else
            System.out.println("Число " + digits + " в степени " + expo + " равно " + result);
    }
}
