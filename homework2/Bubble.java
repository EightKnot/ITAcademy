package HomeWork2;

import java.util.Scanner;

public class Bubble {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        int[] arr = new int[5];
        int buff = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Введите элемент массива №" + (i + 1));
            arr[i] = Integer.parseInt(user.nextLine());
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j+1]) {
                    buff = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = buff;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
