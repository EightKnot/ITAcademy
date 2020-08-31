package HomeWork6;

import java.util.Arrays;

public class DataContainerMain {
    public static void main(String[] args) {
        String[] initArr = new String[5];
        DataContainer<String> dataContainer = new DataContainer<>(initArr);

        System.out.println("ArrLenth: " + dataContainer.storageBox.length + "; ");

        for (int i = 0; i < 10; i++) {
            dataContainer.add(new String("bla-bla" + i));
        }
        dataContainer.printArr();
        System.out.println("ArrLenth: " + dataContainer.storageBox.length);
        System.out.println("Arr item #0: " + dataContainer.get(0));
        System.out.println("Delete arr item #3: " + dataContainer.delete(3));
        System.out.println("Delete arr item \"bla-bla4\": " + dataContainer.delete("bla-bla4"));
        System.out.println("Add/get arr item \"bla-blaTest\": " + dataContainer.get(dataContainer.add("bla-blaTest")));
        dataContainer.printArr();
        /**
         * Сортировка с использованием Comparable
         */
        System.out.println("Сортировка с использованием Comparable");
        dataContainer.delete(5); // Для наглядности результата работы метода sort()
        dataContainer.add("bla-bla4"); //
        dataContainer.printArr();
        DataContainer.sort(dataContainer);
        Arrays.sort(dataContainer.storageBox);
        dataContainer.printArr();
//        DataContainerComparator dataComp = new DataContainerComparator();
//        String[] sortedArr = new String[](dataComp);
    }

}
