package FinalApp;

import java.util.Arrays;

public class Parent {
    String[] namePars;
    String nameWholly;
    boolean genderMale;

    public Parent(String name) {
        namePars = new String[3];
        this.nameWholly = name;
        namePars = name.split("\\s+", 3); // Делим ФИО на Ф, И и О
        if (namePars[2].matches("[А-Я]\\D+(вна)")) { // По суффиксу отчества определяем пол)
            this.genderMale = false;
        } else if (namePars[2].matches("[А-Я]\\D+(вич)")) {
            this.genderMale = true;
        }
    }

    @Override
    public String toString() {
        return "Parent{" +
//                "namePars=" + Arrays.toString(namePars) +
                ", nameWholly='" + nameWholly + '\'' +
                ", genderMale=" + genderMale +
                '}';
    }
}
