package HomeWork1;

import java.util.Scanner;

public class Arrays2 {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Введите элемент массива №" + (i + 1));
            arr[i] = Integer.parseInt(user.nextLine());
        }
        // for
        System.out.print("\nКаждый второй элемент массива: ");
        for (int i = 1; i < arr.length; i+= 2)
            System.out.print(arr[i] + " ");
        // for each
        System.out.print("\nКаждый второй элемент массива: ");
        int i = 1;
        for (int num : arr) {
            if (i % 2 == 0)
                System.out.print(num + " ");
            i++;
        }
    }
}
