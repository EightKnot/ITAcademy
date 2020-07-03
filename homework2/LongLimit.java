package HomeWork2;

public class LongLimit {
    public static void main(String[] args) {
        long a = 1;
        long buff = 0;
        for (; a * 3 > 0; a *= 3) {
        }
        System.out.println("Значение до переполнения\n" + a);
        System.out.println("Значение после переполнения\n" + a * 3);
        // Вариант после просмотра занятий
        a = 1;
        boolean error = false;
        do {
            try {
                a = Math.multiplyExact(a, 3);
            } catch (ArithmeticException zu) {
                error = true;
            }
        } while (!error);
        System.out.println("Значение до переполнения\n" + a);
        System.out.println("Значение после переполнения\n" + a * 3);
    }
}
