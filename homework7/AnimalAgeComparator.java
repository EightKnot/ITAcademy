package HomeWork7;

import java.util.Comparator;

public class AnimalAgeComparator implements Comparator<Animal> {

    /**
     * Сравнивает значения параметров двух объектов типа Animal
     * @param o1
     * @param o2
     * @return положительное число, если значение параметра 1-го объекта больше значения параметра 2-го
     *         0, если значения равны
     *         отрицательное число, если значение параметра 1-го объекта меньше значения параметра 2-го
     */
    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.getAge() - o2.getAge();
    }
}
