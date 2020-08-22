package HomeWork6;

import java.util.Arrays;

public class DataContainer<T> {
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

    T[] incrArr(T[] currArr) {
        return Arrays.copyOf(currArr, (int) (currArr.length * 1.5));
    }
}
