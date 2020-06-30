package HomeWork1;

public class Priority {
    public static void main(String[] args) {
/*

 2.1 5 + 2 / 8 = 5
 2.2 (5 + 2) / 8 = 0
 2.3 (5 + 2++) / 8 = 1 но результат 0
 2.4 (5 + 2++) / --8 = 1
 2.5 (5 * 2 >> 2++) / --8 = 0
 2.6 (5 + 7 > 20 ? 68 : 22 * 2 >> 2++) / --8 = 1
 2.6 (5 + 7 > 20 ? 68 >= 68 : 22 * 2 >> 2++) / --8 = 1
 2.8 6 - 2 > 3 && 12 * 12 <= 119 = false
 2.9 true && false = false

 */

int res[] = new int[6];
int a = 2, b = 8;
        res[0] = 5 + 2 / 8;
        res[1] = (5 + 2) / 8;
        res[2] = (5 + a++) / 8;
        a = 2; b = 8;
        res[3] = (5 + a++) / --b;
        a = 2; b = 8;
        res[4] = (5 * 2 >> a++) / --b;
        a = 2; b = 8;
        res[5] = (5 + 7 > 20 ? 68 : 22 * 2 >> a++) / --b;
        a = 2; b = 8;
  //      res[6] = (5 + 7 > 20 ? 68 >= 68 : 22 * 2 >> a++) / --b;
        boolean bool = 6 - 2 > 3 && 12 * 12 <= 119;
        boolean bool2 = true && false;
for (int i = 0; i < res.length; i++) {
    System.out.println(res[i]);
}
        System.out.println(bool);
        System.out.println(bool2);
    }

}