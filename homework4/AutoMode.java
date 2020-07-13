package HomeWork4;

import java.util.Scanner;

public class AutoMode {
    public static char buffRing = '*';
    public static int ringsTotal = HanoisTowers.rings;
    public static int ringY = 0;

    public static void autoMove(int rings, int from, int to) {
        int buff = 3 - from - to; // Вычисление номера буферного стержня

        if (rings == 1) {
            for (int j = 0; j < ringsTotal; j++) {
                if (HanoisTowers.field[j][from] != '*') {
                    buffRing = HanoisTowers.field[j][from];
                    ringY = j;
                    break;
                }
            }
            for (int j = 0; j < ringsTotal; j++) {
                if (HanoisTowers.field[j][to] != '*' && j != 0) {
                    HanoisTowers.field[j - 1][to] = buffRing;
                    HanoisTowers.field[ringY][from] = '*';
                    break;
                }
                if (HanoisTowers.field[j][to] == '*' && j == ringsTotal - 1) {
                    HanoisTowers.field[j][to] = buffRing;
                    HanoisTowers.field[ringY][from] = '*';
                }
            }
            if (HanoisTowers.chekFinish()) {
                HanoisTowers.score++;
                HanoisTowers.printField();
                System.out.println("Делов-то!");
                System.exit(0);
            }
        }
        else {
            autoMove(rings - 1, from, buff);
            autoMove(1, from, to);
            autoMove(rings - 1, buff, to);
        }
        HanoisTowers.score++;
        HanoisTowers.printField();
    }
}
