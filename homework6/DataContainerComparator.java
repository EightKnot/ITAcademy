package HomeWork6;

import HomeWork7.Person;

import java.util.Comparator;

public class DataContainerComparator implements Comparator<DataContainer> {

    /**
     * Сравнивает длину параметров двух объектов типа Person
     * @param o1
     * @param o2
     * @return положительное число, если длина параметра 1-го объекта больше длины параметра 2-го
     *         0, если длины равны
     *         отрицательное число, если длина параметра 1-го объекта меньше длины параметра 2-го
     */
    @Override
    public int compare(DataContainer o1, DataContainer o2) {
        return o1.storageBox.hashCode() - o2.storageBox.hashCode();
    }
}
