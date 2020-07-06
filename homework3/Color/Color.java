package HomeWork3.Color;

public class Color {
    private int number;
    private String name;
    private final int RED = 1;
    private final int ORANGE = 2;
    private final int YELLOW = 3;
    private final int GREEN = 4;
    private final int BLUE = 5;
    private final int NAVY = 6;
    private final int PURPLE = 7;

    public Color(int color) {
        this.number = color;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        switch (number) {
            case RED:
                return "Красный";
            case ORANGE:
                return "Оранжевый";
            case YELLOW:
                return "Жёлтый";
            case GREEN:
                return "Зеленый";
            case BLUE:
                return "Голубой";
            case NAVY:
                return "Синий";
            case PURPLE:
                return "Фиолетовый";
        }
        return "Неизвестно";
    }
}
