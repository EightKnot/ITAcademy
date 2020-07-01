package HomeWork2;

public class LongLimit {
    public static void main(String[] args) {
        long a = 1;
        for (; a * 3 > 0; a *= 3) {
        }
        System.out.println("Значение до переполнения\n" + a);
        System.out.println("Значение после переполнения\n" + a * 3);
    }
}
