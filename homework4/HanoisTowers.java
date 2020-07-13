package HomeWork4;

import java.util.Scanner;

/**
 * Класс реализует головоломку "Ханойские башни" в двух режимах: ручном и автоматическом.
 * Количество дисков не должно превышать 9.
 * Подсчет количества ходов в автоматическом режиме ведется некорректно при перемещении нижнего диска...
 */
public class HanoisTowers {
    public static int rings = 7; // Исходное количество дисков
    public static char[][] field = new char[rings][3]; // Игровое поле
    public static char buffRing; // Буфер для хранения перемещаемого диска
    public static int score = 0; // Для подсчета количества сделанных ходов

    public static void main(String[] args) {

        int towerFrom; // Для хранения введенного через консоль значения
        int towerTo; // Для хранения введенного через консоль значения
        int gameMode; // Режим (ручной или автоматический)

        Scanner scanner = new Scanner(System.in);
        /**
         * Создание массива, хранящего элементы игрового поля
         */
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
        /**
         * Ручной режим
         */
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
        /**
         * Автоматический режим
         */
        if (gameMode == 2) {
            printField();
            AutoMode.autoMove(rings, 0, 2);
        }
    }

    /**
     * Перемещение верхнего диска
     * @param from откуда
     * @param to куда
     * @return true - если этот ход не противоречит правилам, false - если запрещен
     */
    public static boolean move(int from, int to) {
        int fieldI = 0; // Для замены перемещенного диска символом '*', если условия не нарушены
        from--;
        to--;
        /**
         * Ищем верхнее кольцо
         */
        for (int i = 0; i < rings; i++) {
            if (field[i][from] != '*') {
                    buffRing = field[i][from];
                    fieldI = i;
                    break;
            }
        }
        /**
         * "Нанизываем" на целевой стержень, если условия соблюдены
         */
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

    /**
     * Прорисовка игрового поля
     */
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

    /**
     * Проверка, собрана ли целевая башня
     * @return
     */
    public static boolean chekFinish() {
        for (int i = 0; i < rings; i++) {
                if (field[i][2] != i +1 + '0')
                    return false;
        }
        return true;
    }
}
