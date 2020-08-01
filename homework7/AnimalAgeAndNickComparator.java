package HomeWork7;

import java.util.Comparator;

public class AnimalAgeAndNickComparator implements Comparator<Animal> {

    // Технологичнее, наверное, было бы использовать thenComparing() и два класса (для каждого параметра свой).
    // Но как это реализовать через один класс, я не допер... Поэтому сделал по-простецки...
    // В принципе, по такой схеме можно продолжать для сколь угодно большого количества параметров...

    /**
     * Сравнивает значения двух параметров двух объектов типа Animal: возраст и, если он равен,
     * клички по алфавиту
     * @param o1
     * @param o2
     * @return положительное число, если значения параметров 1-го объекта "больше" значений параметров 2-го
     *         0, если значения равны
     *         отрицательное число, если значения параметров 1-го объекта "меньше" значений параметров 2-го
     */
    @Override
    public int compare(Animal o1, Animal o2) {
        int result = o1.getAge() - o2.getAge();
        if (result != 0)
            return result;
        else
            return o1.getNick().compareTo(o2.getNick());
    }
}
