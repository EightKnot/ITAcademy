package HomeWork7;

import java.util.Comparator;

public class PersonPasswordAndNickComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Person per1 = new Person("", "");
        Person per2 = new Person("", "");
        per1 = (Person) o1;
        per2 = (Person) o2;
        if (per1.getPassword().length() > per2.getPassword().length())
            return 1;
        else if (per1.getPassword().length() != per2.getPassword().length())
            return 2;
        return 0;
    }
}
