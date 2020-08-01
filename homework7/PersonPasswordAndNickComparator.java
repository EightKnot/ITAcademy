package HomeWork7;

import java.util.Comparator;

public class PersonPasswordAndNickComparator implements Comparator<Person> {

    // Технологичнее, наверное, было бы использовать thenComparing() и два класса (для каждого параметра свой).
    // Но как это реализовать через один класс, я не допер... Поэтому сделал по-простецки...
    // В принципе, по такой схеме можно продолжать для сколь угодно большого количества параметров...

    /**
     * Сравнивает два объекта типа Person по двум параметрам: по длине пароля и, если длина равная,
     * по имени
     * @param o1
     * @param o2
     * @return положительное число, если два параметра 1-го объекта "больше" двух параметров 2-го
     *         0, если параметры равны
     *         отрицательное число, если два параметра 1-го объекта "меньше" двух параметров 2-го
     */
    @Override
    public int compare(Person o1, Person o2) {
        int result = o1.getPassword().length() - o2.getPassword().length();
        if (result != 0)
            return result;
        else
            return o1.getNick().compareTo(o2.getNick());
    }
}
