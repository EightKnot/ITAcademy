package HomeWork1;

import java.util.Scanner;

public class Arrays1 {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Введите элемент массива №" + (i + 1));
            arr[i] = Integer.parseInt(user.nextLine());
        }
        // do while
        int i = 0;
        System.out.print("Элементы массива: ");
        do {
            System.out.print(arr[i] + " ");
            i++;
        } while (i < arr.length);
        // while
        i = 0;
        System.out.print("\nЭлементы массива: ");
        while (i < arr.length) {
            System.out.print(arr[i] + " ");
            i++;
        }
        // for
        System.out.print("\nЭлементы массива: ");
        for (i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        // for each
        System.out.print("\nЭлементы массива: ");
        for (int num : arr)
            System.out.print(num + " ");
    }
}
