package HomeWork7;

import java.util.Comparator;

public class PersonPasswordComparator implements Comparator<Person> {

    /**
     * Сравнивает длину параметров двух объектов типа Person
     * @param o1
     * @param o2
     * @return положительное число, если длина параметра 1-го объекта больше длины параметра 2-го
     *         0, если длины равны
     *         отрицательное число, если длина параметра 1-го объекта меньше длины параметра 2-го
     */
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getPassword().length() - o2.getPassword().length();
    }
}
