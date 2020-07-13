package HomeWork4;

import java.util.Scanner;

public class HanoisTowers {
    public static int rings = 3;
    public static char[][] field = new char[rings][3];
    public static char buffRing;
    public static int score = 0;

    public static void main(String[] args) {

        int towerFrom;
        int towerTo;
        int gameMode;

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < rings; i++) {
            field[i][0] = (char) (i + 1 + '0');
            for (int j = 1; j < 3; j++) {
                field[i][j] = '*';
            }
        }

        do {
            System.out.println("Выберите режим (1 - ручной, 2 - автоматический):");
            gameMode = scanner.nextInt();
        } while (gameMode != 1 && gameMode != 2);

        if (gameMode == 1) {
            for (;;) {
                if (chekFinish()) {
                    printField();
                    System.out.println("Ура!!! Тебе удалось! Минимально возможное количество ходов: " + (int) (Math.pow(2, rings) - 1));
                    return;
                }

                printField();

                System.out.println("Введите номер исходного стержня:");
                towerFrom = scanner.nextInt();

                System.out.println("Введите номер конечного стержня:");
                towerTo = scanner.nextInt();

                if (!move(towerFrom, towerTo))
                    System.out.println("Нарушение правил! Повторите попытку.");
                else score++;
            }
        }
        if (gameMode == 2) {
            printField();
            AutoMode.autoMove(rings, 0, 2);
        }
    }

    public static boolean move(int from, int to) {
        int fieldI = 0;
        from--;
        to--;
        for (int i = 0; i < rings; i++) {
            if (field[i][from] != '*') {
                    buffRing = field[i][from];
                    fieldI = i;
                    break;
            }
        }
        for (int i = 0; i < rings; i++) {
            if (field[i][to] != '*' && field[i][to] > buffRing) {
                field[i - 1][to] = buffRing;
                field[fieldI][from] = '*';
                return true;
            }
            if (field[i][to] != '*' && field[i][to] < buffRing)
                return false;
        }
        field[fieldI][from] = '*';
        field[rings - 1][to] = buffRing;
        return true;
    }

    public static void printField() {
        for (int i = 0; i < rings; i++) {
            System.out.println();
            for (int j = 0; j < 3; j++) {
                System.out.print(field[i][j] + " ");
                if (i == 0 && j == 2)
                    System.out.print("   Количество ходов: " + score);
            }
        }
        System.out.println();
    }
    public static boolean chekFinish() {
        for (int i = 0; i < rings; i++) {
                if (field[i][2] != i +1 + '0')
                    return false;
        }
        return true;
    }
}
