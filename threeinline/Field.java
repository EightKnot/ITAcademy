package ThreeInLine;

import java.util.Scanner;

public class Field {
    public static int level = 1;
    int points = 0;
    int buff;
    int digRange = 4;
    int arrLengthX;
    int arrLengthY;
    public static int fieldSizeX = 3 + level;
    int fieldSizeY = 3 + level;
    public static int fieldSizeYMax = 20;
    static int[][] field = new int[fieldSizeYMax][fieldSizeX];
    String userMove;

    public static int getField(int i, int j) {
        return field[i][j];
    }

    public int getArrLengthX(int i) {
        return field[i].length;
    }

    public int getArrLengthY() {
        return field.length;
    }

    public Field() {    // создает массив игрового поля
        for (int i = 0; i < fieldSizeY; i++)
            for (int j = 0; j < fieldSizeX; j++)
                field[i][j] = (int) (Math.random() * (digRange+1));
    }

    void fieldIncr() {   // увеличивает размер игрового поля на 1
        fieldSizeY++;
        for (int j = 0; j < fieldSizeX; j++)
            field[fieldSizeY-1][j] = (int) (Math.random() * (digRange+1));
    }

    void draw() {     // прорисовывает игровое поле
        System.out.print("   ");
        for (int i = 1; i <= fieldSizeX; i++) {
            System.out.print(" " + i);
        }
        System.out.println("   Pts: " + points + "\n");
        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print(i+1 + "   ");
            for (int j = 0; j < fieldSizeX; j++)
                System.out.print(field[i][j] + " ");
            System.out.println();
        }
    }

    void move() {         // получает данные из консоли и производит перемещение символов в массиве
        Scanner user = new Scanner(System.in);
        userMove = user.nextLine();
        char ch;
        int x, y;
        int indCh = userMove.indexOf(",");
        String d = userMove.substring(0,indCh);
        x = Integer.parseInt(d)-1;
        int indCh2 = userMove.indexOf(" ", indCh+1);
        d = userMove.substring(indCh+1, indCh2);
        y = Integer.parseInt(d)-1;

        switch (userMove.substring(indCh2+1)) {
            case "up":
                System.out.print(y+" "+x);  // для проверки полученных значений
                System.out.println("up");
                buff = field[x][y];
                field[x][y] = field[x-1][y];
                field[x-1][y] = buff;
                break;
            case "down":
                System.out.print(y+" "+x);
                System.out.println("down");
                buff = field[x][y];
                field[x][y] = field[x+1][y];
                field[x+1][y] = buff;
                break;
            case "left":
                System.out.print(y+" "+x);
                System.out.println("left");
                buff = field[x][y];
                field[x][y] = field[x][y-1];
                field[x][y-1] = buff;
                break;
            case "right":
                System.out.print(y+" "+x);
                System.out.println("right");
                buff = field[x][y];
                field[x][y] = field[x][y+1];
                field[x][y+1] = buff;
                break;
            default:
                System.out.println("оБшиБка");
        }



//        System.out.println(userMove);

    }

    void analyze() {   // поиск совпадений в ряд
        for (int i = 0; i < fieldSizeY-2; i++)
            for (int j = 0; j < fieldSizeX -2; j++) {
                if (field[i][j] == field[i][j + 1]) {
                    int n = i, m = j, lenght = 1;
                    while (field[n][m] == field[n][m + 1] && n < fieldSizeX && m < fieldSizeY) {
                        lenght++;
                        m++;
                    }
                    if (lenght > 2) {
                        gener(i, j, (byte) 1, lenght);
                        points += lenght;
                    }
                }

                if (field[i][j] == field[i+1][j]) {
                    int n = i, m = j, lenght = 1;
                    while (field[n][m] == field[n+1][m] && n < fieldSizeX && m < fieldSizeY) {
                        lenght++;
                        m++;
                    }
                    if (lenght > 2) {
                        gener(i, j, (byte) 0, lenght);
                        points += lenght;
                    }
                }
            }
    }

    void gener(int x1, int y1, byte direction, int length) {   // замена линии на новые значения
        if (direction == 0)
            for (int i = 0; i <= length; i++)
                field[x1+i][y1] = (int) (Math.random() * (digRange+1));
        else
            for (int i = 0; i <= length; i++)
                field[x1][y1+i] = (int) (Math.random() * (digRange+1));
    }

}