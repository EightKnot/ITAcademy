package HomeWork7_2;

import HomeWork7.Animal;

import java.util.Comparator;
import java.util.Map;

public class WordMapComparator implements Comparator<Map.Entry<String, Integer>> {

    /**
     * Сравнивает значения параметров двух объектов типа Animal
     * @param o1
     * @param o2
     * @return положительное число, если значение параметра 1-го объекта больше значения параметра 2-го
     *         0, если значения равны
     *         отрицательное число, если значение параметра 1-го объекта меньше значения параметра 2-го
     */
    @Override
    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        return o1.getValue() - o2.getValue();
    }
}
