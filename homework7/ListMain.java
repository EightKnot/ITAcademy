package HomeWork7;

import java.util.*;

public class ListMain {
    public static void main(String[] args) {
        int listSize = 1_000_000;
        long startTime = 0;
        long finishTime = 0;
        long linkedTime = 0;
        long arrayTime = 0;
        Date date = new Date();

        List<Person> personList = new LinkedList<>(); // Время записи в список LinkedList: 2064 миллисекунд

        startTime = System.currentTimeMillis();

        for (int i = 0; i < listSize; i++) {
            personList.add(new Person(RandomString.random(5), RandomString.random(RandomString.random(5, 10))));
        }

        finishTime = System.currentTimeMillis();
        linkedTime = finishTime - startTime;

        List<Animal> animalList = new ArrayList<>(); // Время записи в список ArrayList: 923 миллисекунд

        startTime = System.currentTimeMillis();

        for (int i = 0; i < listSize; i++) {
            animalList.add(new Animal(RandomString.random(1, 15), RandomString.random(5)));
        }

/*        personList.add(0, new Person("ABC", "ЯБ В")); // Использовал для проверки сортировки
        personList.add(1, new Person("ZBC", "АБ В"));
        personList.add(2, new Person("ABA", "АБ Г"));
        personList.add(3, new Person("ABD", "АБ  В"));
        personList.add(4, new Person("ABC", "АА"));
        personList.add(5, new Person("ABE", "АА"));
        personList.add(6, new Person("ABC", "АБ  Б"));

        animalList.add(0, new Animal(1, "ЯБВ"));
        animalList.add(1, new Animal(2, "АБВ"));
        animalList.add(2, new Animal(1, "АБГ"));
        animalList.add(3, new Animal(2, "АБВ"));
        animalList.add(4, new Animal(1, "АБА"));
        animalList.add(5, new Animal(3, "ААА"));
        animalList.add(6, new Animal(1, "АББ"));*/
        
        finishTime = System.currentTimeMillis();
        arrayTime = finishTime - startTime;
        /**
        * Сортировка списков
        */
//        PersonPasswordComparator compPerPass = new PersonPasswordComparator(); // Сортировка списка по длине пароля
//        Collections.sort(personList, compPerPass);
        PersonPasswordAndNickComparator compPerPassNick = new PersonPasswordAndNickComparator(); // Сортировка списка по длине пароля
        Collections.sort(personList, compPerPassNick);

//        AnimalAgeComparator compAniAge = new AnimalAgeComparator(); // Сортировка списка по возрасту
//        Collections.sort(animalList, compAniAge);
        AnimalAgeAndNickComparator compAnimAgeNick = new AnimalAgeAndNickComparator(); // Сортировка списка по возрасту и кличке
        Collections.sort(animalList, compAnimAgeNick);


        System.out.println("Время записи в список LinkedList: " + linkedTime + " миллисекунд\n"
                + "Скорость записи в список LinkedList: " + listSize / linkedTime * 1000 + " записей в секунду.\n");
        System.out.println("Время записи в список ArrayList: " + arrayTime + " миллисекунд\n"
                + "Скорость записи в список ArrayList: " + listSize / arrayTime * 1000 + " записей в секунду.\n");

        /**
         * Удаление элементов списков
         */
        System.out.println("Размер списка Person до удаления: " + personList.size());
        Iterator<Person> iterator = personList.iterator();
        startTime = System.currentTimeMillis();
        while (iterator.hasNext())
            personList.clear(); // Время, затраченное на удаление: 34
        finishTime = System.currentTimeMillis();
        System.out.println("Размер списка Person после удаления: " + personList.size());
        System.out.println("Время, затраченное на удаление: " + (finishTime - startTime) + " миллисекунд\n");

        System.out.println("Размер списка Animal до удаления: " + animalList.size());
        startTime = System.currentTimeMillis();
        for (int i = 0; i < animalList.size();)
            animalList.remove(i); // Время, затраченное на удаление: 181031
        finishTime = System.currentTimeMillis();
        System.out.println("Размер списка Animal после удаления: " + animalList.size());
        System.out.println("Время, затраченное на удаление: " + (finishTime - startTime) + " миллисекунд");
        }
}
