package HomeWork7;

import java.util.*;

public class ListMain {
    public static void main(String[] args) {
        int listSize = 1000000;
        long startTime = 0;
        long finishTime = 0;
        long linkedTime = 0;
        long arrayTime = 0;

        List<Person> personList = new LinkedList<>(); // Время записи в список LinkedList: 2064 миллисекунд

        Date date = new Date();
        startTime = System.currentTimeMillis();
        System.out.println(startTime);
        for (int i = 0; i < listSize; i++) {
            personList.add(new Person(RandomString.random(5), RandomString.random(RandomString.random(5, 10))));
        }
        finishTime = System.currentTimeMillis();
        System.out.println(finishTime);
        linkedTime = finishTime - startTime;

        List<Animal> animalList = new ArrayList<>(); // Время записи в список ArrayList: 923 миллисекунд

        startTime = System.currentTimeMillis();
        for (int i = 0; i < listSize; i++) {
            animalList.add(new Animal(RandomString.random(1, 15), RandomString.random(5)));
        }
        finishTime = System.currentTimeMillis();
        arrayTime = finishTime - startTime;

        PersonPasswordComparator compPerPass = new PersonPasswordComparator();
        Collections.sort(personList, compPerPass);

        AnimalAgeComparator compAniAge = new AnimalAgeComparator();
        Collections.sort(animalList, compAniAge);



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
