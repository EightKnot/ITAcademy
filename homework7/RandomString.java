package HomeWork7;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RandomString {

    /**
     *  Метод для ввода диапазона значений рандома через консоль. На случай заполнения списка небольшим
     *  количеством элементов.
     * @param firstDig Добавить к имеющимуся диапазону новый со значениями по таблице ASCII от firstDig
     * @param lastDig до lastDig
     * @return Возвращает строку длиной stringLength, содержащую случайные символы из заданного диапазона
     */
/**
    public static String random(int stringLength) {
        String charArray = "";
        String firstChar = "";
        String lastChar = "";
        String exitPoint = "";
        String returnString = "";
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Начальный символ диапазона:");
            firstChar = scanner.next();
            System.out.println("Конечный символ диапазона:");
            lastChar = scanner.next();
            System.out.println("Продолжить? да/нет:");
            exitPoint = scanner.next().toLowerCase();
            charArray = charArray.concat(charConcat(firstChar.charAt(0), lastChar.charAt(0))); // charAt(0) - на случай, если случайно введено более 1 символа
        } while (exitPoint.compareTo("н") != 0);

        System.out.println("Сформирован массив символов: " + charArray);

        int rand = 0;
        for (int i = 0; i < stringLength; i++) {
            rand = (int) (Math.random() * charArray.length());
            returnString = returnString.concat(String.valueOf(charArray.charAt(rand)));
        }
        return returnString;
    }
*/
    /**
     * Мотод, формирующий строку из заданного диапазона символов
     * @param begin
     * @param finish
     * @return
     */
/**
    public static String charConcat(char begin, char finish) {
        char ch = ' ';
        String stringBox = "";
        for (int i = begin; i < finish + 1; i++) {
            ch = (char) i;
            stringBox = stringBox.concat(String.valueOf(ch));
        }
        return stringBox;
    }
*/

    /**
     * Топорный вариант) Но самый быстрый из придуманных мной...
     * Строка используется как массив символов для случайной выборки.
     * Строку charArray разбил на несколько диапазонов для придания методу хоть какой-то гибкости.
     * @param stringLength
     * @return
     */
    public static String random(int stringLength) {
        String charArray = "abcdefghijklmnopqrstuvwxyz";
        charArray = charArray.concat("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        charArray = charArray.concat("абвгдеёжзийклмнопрстуфхцчшщъыьэюя");
        charArray = charArray.concat("АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ");
        charArray = charArray.concat("0123456789 ");
        String returnString = "";

//        System.out.println("Сформирован массив символов: " + charArray);

        int rand = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < stringLength; i++) {
            rand = (int) (Math.random() * charArray.length());
//            returnString = returnString.concat(String.valueOf(charArray.charAt(rand))); // 2340 миллисекунд
            builder.append(charArray.charAt(rand)); // 1897 миллисекунд
        }
//        System.out.println("Получили строку: " + returnString);
        return builder.toString();
    }


    /**
     * Корявенький, но самый гибкий, метод. И ооочень медленный...
     * @param stringLength
     * @return
     */
/**
    public static String random(int stringLength) {
        String tempStr = "";
        char tempChar = ' ';
        String regEx = "[a-zA-Zа-яА-Я0-9 ]";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < stringLength;) {
            tempChar = (char) (Math.random() * 1150); // Диапазон таблицы ASCII
            tempStr = String.valueOf(tempChar);
            if (tempStr.matches(regEx)) {
                builder.append(tempStr);
                i++;
            }
        }
        return builder.toString();
    }
*/
    /**
     * Для генерации чисел из заданного диапазона
     * (По условию задания его здесь быть не должно. Его можно прописать
     * в другом классе, но, как по мне, логичнее ему быть здесь...)
     * Насколько я смог разобраться, это не перегрузка, т.к. у них типы разные возвращаемых значений.
     * @param firstDig
     * @param lastDig
     * @return
     */
    public static int random(int firstDig, int lastDig) {
        return (int) (Math.random() * (lastDig - firstDig)) + firstDig;
    }
}
