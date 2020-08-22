package HomeWork6;

public class DataContainerMain {
    public static void main(String[] args) {
        String[] initArr = new String[5];
        DataContainer<String> dataContainer = new DataContainer<>(initArr);

        System.out.println("ArrLenth: " + dataContainer.storageBox.length + "; ");

        for (int i = 0; i < 10; i++) {
            dataContainer.add(new String("bla-bla" + i));
        }
        for (int i = 0; i < dataContainer.storageBox.length; i++) {
            System.out.printf(dataContainer.get(i) + " | ");
        }
        System.out.println("ArrLenth: " + dataContainer.storageBox.length);
        System.out.println("Arr item #0: " + dataContainer.get(0));
        System.out.println("Delete arr item #3: " + dataContainer.delete(3));
        System.out.println("Delete arr item \"bla-bla4\": " + dataContainer.delete("bla-bla4"));
        System.out.println("Add/get arr item \"bla-blaTest\": " + dataContainer.get(dataContainer.add("bla-blaTest")));
        for (int i = 0; i < dataContainer.storageBox.length; i++) {
            System.out.printf(dataContainer.get(i) + " | ");
        }
    }
}
