package FinalApp;

import java.util.Arrays;

public class Teacher {
    final String ANSI_BLUE = "\u001B[34m";
    final String ANSI_SOLID = "\033[1m";
    final String ANSI_RESET = "\u001B[0m";
    String[] namePars;
    String nameWholly;
    Subject[] subjects;
    Category category;
    double averageCertRating;
    double baseQualityIndex;
    boolean hiddenPotential;
    double dailyCost;
    double costIndex = 1;
    double baseDailyCost = 30;

    public Teacher() {
    }

    public Teacher(String name) {
        this.namePars = new String[3];
        this.nameWholly = name;
        this.namePars = name.split("\\s+", 3);
        this.subjects = new Subject[3];

        if (Math.random() > 0.7) {
            if (Math.random() < 0.7) {
                this.category = Category.CAT0;
                this.costIndex = 0.5;
            } else {
                this.category = Category.CAT3;
                this.costIndex = 1;
            }
        } else {
            if (Math.random() < 0.5) {
                this.category = Category.CAT1;
                this.costIndex = 0.6;
            } else  {
                this.category = Category.CAT2;
                this.costIndex = 0.8;
            }
        }

        double k = Math.random();
        switch (this.category) {
            case CAT0:
                this.averageCertRating = Math.random() * 6 + 4;
                break;
            case CAT1:
                this.averageCertRating = Math.random() * 4 + 6;
                break;
            case CAT2:
                this.averageCertRating = Math.random() * 3 + 7;
                break;
            case CAT3:
                this.averageCertRating = Math.random() * 2 + 8;
                break;
        }
        randomCharacteristic(k);
        getDailyCost();
    }

    enum Category {
        CAT0(0,"Начинающий специалист"),
        CAT1(1,"Преподаватель 1-ой категории"),
        CAT2(2,"Преподаватель 2-ой категории"),
        CAT3(3,"Преподаватель высшей категории");

        private int id;
        private String category;

        Category (int id, String category) {
            this.id = id;
            this.category = category;
        }

        public String getCategory() {
            return category;
        }
    }

    public void setSubjects(Subject subject) {
        for (int i = 0; i < this.subjects.length; i++) {
            if (this.subjects[i] == null) {
                this.subjects[i] = subject;
                break;
            } else {
                try {
                    throw new Exception("Преподаватель не может вести более" + this.subjects.length + "предмета(-ов) одновременно");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void getDailyCost() { // дописать
        if (this.baseQualityIndex > 0.8) {
            this.dailyCost = (this.costIndex * this.subjects.length + 0.3) * this.baseDailyCost;
        } else {
            this.dailyCost = (this.costIndex * this.subjects.length) * this.baseDailyCost;
        }
    }

    void randomCharacteristic (double random) {
        if (random < 0.5) {
            this.hiddenPotential = true;
            random *= -1;
        } else {
            this.hiddenPotential = false;
            random -= 0.5;
        }
        this.baseQualityIndex = averageCertRating / 10 + random;
    }


/*    @Override
    public String toString() {
        return "Teacher{" +
//                "namePars=" + Arrays.toString(namePars) +
                ", nameWholly='" + nameWholly + '\'' +
//                ", subjects=" + Arrays.toString(subjects) +
                ", subjects=" + subjects[0].name + ", " + subjects[1]+ ", " + subjects[2] + ", " +
                ", category=" + category.getCategory() +
                ", averageCertRating=" + averageCertRating +
                ", baseQualityIndex=" + baseQualityIndex +
//                ", hiddenPotential=" + hiddenPotential +
                ", dailyCost=" + dailyCost +
                '}';
    }*/

    public void printData() {
        System.out.printf("Teacher{" +
//                "namePars=" + Arrays.toString(namePars) +
                ", Имя='" + nameWholly + '\'' + ANSI_BLUE +
//                ", subjects=" + Arrays.toString(subjects) +
                ", Предметы=" + subjects[0].name + ", " + subjects[1]+ ", " + subjects[2] + ", " + ANSI_RESET +
                ", Категория=" + category.getCategory() + "\n" +
                ", averageCertRating=%.3f" + "\n" +
                ", baseQualityIndex=%.3f" + "\n" +
                ", Потенциал=" + hiddenPotential + "\n" +
                ", dailyCost=%.2f" +
                '}' + "\n", averageCertRating, baseQualityIndex, dailyCost);
    }
}
