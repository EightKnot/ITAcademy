package HomeWork6;

import java.util.Arrays;
import java.util.Objects;

public class DataContainer<T> implements Comparable<T> {
    public T[] storageBox;

    DataContainer(T[] initArr) {
        this.storageBox = initArr;
    }

    int add(T item) {
        for (int i = 0; i < this.storageBox.length; i++) {
            if (this.storageBox[i] == null) {
                this.storageBox[i] = item;
                return i;
            }
        }
        this.storageBox = incrArr(this.storageBox);
        add(item);
        return 0;
    }

    T get(int index) {
        return this.storageBox[index];
    }

    T[] getItems() {
        return this.storageBox;
    }

    boolean delete(int index) {
        if (this.storageBox[index] != null) {
            for (int i = index; i < this.storageBox.length - 1; i++) {
                this.storageBox[i] = this.storageBox[i + 1];
            }
            this.storageBox[this.storageBox.length - 1] = null;
            return true;
        } else {
            return false;
        }
    }

    boolean delete(T item) {
        for (int i = 0; i < this.storageBox.length; i++) {
            if (this.storageBox[i].equals(item)) {
                for (int j = i; j < this.storageBox.length - 1; j++) {
                    this.storageBox[j] = this.storageBox[j + 1];
                }
                this.storageBox[storageBox.length - 1] = null;
                return true;
            }
        }
        return false;
    }

    int getIndex(T item) {
        for (int i = 0; i < this.storageBox.length; i++) {
            if (this.storageBox[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    T[] incrArr(T[] currArr) {
        return Arrays.copyOf(currArr, (int) (currArr.length * 1.5));
    }
    /**
     * Сортировка массива с использованием Comparable
     * С помощью метода add не изменяя размер массива и без лишнего кода узнаем "полезную" длину массива
     * И укорачиваем его, если есть пустые элементы
     */
    static void sort(DataContainer dataContainer) {
        dataContainer.storageBox = Arrays.copyOf(dataContainer.storageBox, dataContainer.add(null));
        Arrays.sort(dataContainer.storageBox);
    }

    void printArr() {
        for (int i = 0; i < this.storageBox.length; i++) {
            System.out.printf(this.get(i) + " | ");
        }
        System.out.println();
    }

    @Override
    public int compareTo(T o) {
//        return this.storageBox[this.getIndex(o) - 1].hashCode() - o.hashCode();
        return  o.hashCode() - this.storageBox[this.getIndex(o) - 1].hashCode(); // По убыванию
    }
}
