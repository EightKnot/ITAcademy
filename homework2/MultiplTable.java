package HomeWork2;

public class MultiplTable {
    public static void main(String[] args) {
        // Хочу таблицу умножения чисел от а до b, умноженных на (от с до d), в е ряда(-ов)
        int a = 1;
        int b = 11;
        int c = 1;
        int d = 10;
        int e = 4;
        int m = 0;
        if ((b - a + 1) % e == 0)
            m = (b - a + 1) / e;
        else m = (b - a + 1) / e + 1;
        for (int i = 1, g = 0; i <= e; i++) {
            System.out.println();
            g = m + a;
            if (g > b)
                g = b + 1;
            for (int j = c; j <= d; j++) {
                if (e != 1) {
                    System.out.println();
                    for (int k = a; k < g; k++) {
                       System.out.print(k +" x " + j);
                       if (j < 10)
                           System.out.print("  ");
                       else System.out.print(" ");
                        System.out.print("= " + k * j);
                        if (k * j < 10)
                            System.out.print("   ");
                        else System.out.print("  ");
                     }
                }
            }
            a += m;
        }
    }
}
