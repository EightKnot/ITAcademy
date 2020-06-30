package HomeWork1;


import java.util.Scanner;


public class HelloVasia {

    public static void main(String[] args) {

        System.out.println("Введите свое имя:");
        Objects1.equals("Вася", "Анастасия");
        System.out.println("Введите свое имя:");
        Objects2.equals("Вася", "Анастасия");
        System.out.println("Введите свое имя:");
        Objects3.equals("Вася", "Анастасия");
    }

    public static class Objects1 {

        public static void equals(String name1, String name2) {
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
        if (s.equals(name1))
            System.out.println("Привет!\nЯ тебя так долго ждал");
        if (s.equals(name2))
            System.out.println("Я тебя так долго ждал");
        if (!s.equals(name1)  && !s.equals(name2))
            System.out.println("Добрый день, а вы кто?");
        }
    }

    public static class Objects2 {

        public static void equals(String name1, String name2) {
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
        if (s.equals(name1))
            System.out.println("Привет!\nЯ тебя так долго ждал");
        else if (s.equals(name2))
            System.out.println("Я тебя так долго ждал");
        else
            System.out.println("Добрый день, а вы кто?");
        }
    }

    public static class Objects3 {

        public static void equals(String name1, String name2) {
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
        switch (s) {
            case ("Вася"):
                System.out.println("Привет!\nЯ тебя так долго ждал");
                break;
            case ("Анастасия"):
                System.out.println("Я тебя так долго ждал");
                break;
            default:
                System.out.println("Добрый день, а вы кто?");
        }
        }
    }

}
