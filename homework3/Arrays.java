package HomeWork3;

import java.lang.reflect.Array;

public class Arrays {
    public static void main(String[] args) {
        int[][] arrMass = new int[6][];
        arrMass[0] = new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5};
        arrMass[1] = new int[]{1,1,2,-2,5,2,4,4,-1,-2,5};
        arrMass[2] = new int[]{20,1,1,2,2,3,3,5,5,4,20,4,5};
        arrMass[3] = new int[]{10};
        arrMass[4] = new int[]{1,1,1,1,1,1,10,1,1,1,1};
        arrMass[5] = new int[]{5,4,3,2,1,5,4,3,2,10,10};
        for (int i = 0; i < arrMass.length; i++) {
            System.out.print("Массив №" + (i + 1) + ":  ");
            for (int j = 0; j < arrMass[i].length; j++) {
                System.out.print(arrMass[i][j] + "  ");
            }
            System.out.println();
        }
        for (int i = 0; i < arrMass.length; i++) {
            System.out.println("В массиве №" + (i + 1) + " число " + arrCount(arrMass[i]) + " повторяется нечетное количество раз.");
        }
    }
    /**
     * Метод поиска элемента передаваемого массива, повторяющегося нечетное количество раз
     * @param arr передаваемый методу массив
     * @return возвращает искомый элемент массива
     */
    public static int arrCount(int[] arr) {
        int digCount = 1;   // Счетчик повторений массива
        int arrValue = 0;   // Значение повторяющегося элемента
        boolean arrRepeat = false;   // Участвовал ли этот элемент в сравнении
        if (arr.length < 2)   // Хватает ли элементов массива хотя бы для одного сравнения
            return arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arrValue = arr[i];
            arrRepeat = false;
            /**
             * Проверяем, участвовал ли этот элемент в сравнении (сравниваем с элементами "слева")
             */
            for (int k = 0; k < i; k++) {
                if (arr[k] == arr[i]) {
                    arrRepeat = true;
                    break;
                }
            }
            if (arrRepeat)
                continue;
            /**
             * Последовательно сравниваем текущий элемент массива с остальными "справа от него"
             */
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j])
                    digCount++;
            }
            /**
             * Проверка на нечетность повторений элемента
             */
            if (digCount % 2 != 0)
                break;
            else digCount = 1;
        }
        return arrValue;
    }
}
