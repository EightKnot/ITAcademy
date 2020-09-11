package FinalApp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GamePlay {

    final String ANSI_BLUE = "\u001B[34m";
    final String ANSI_RED = "\u001B[31m";
    final String ANSI_SOLID = "\033[1m";
    final String ANSI_RESET = "\u001B[0m";
    ArrayList<String> nameList = new ArrayList<>();
    ArrayList<Parent> parentsMale = new ArrayList<>();
    ArrayList<Parent> parentsFemale = new ArrayList<>();
    ArrayList<Family> families = new ArrayList<>();
    Teacher[] teachers;
    Pupil[] pupils;
    Subject[] subjects;
    int numberOfPupils = 100;
    int numberOfСandidates = 30;
    List<Teacher> teachTemp;



    public GamePlay() {
        nameList();
        parentList(numberOfPupils * 2);
        pupils = pupilList(100);
        families = familyList(numberOfPupils);
        teachers = teacherList(30); // temp
        subjects = subjectList();
        teachTemp = Arrays.asList(teacherList(numberOfСandidates));
    }

    public Teacher[] getTeachers() {
        return teachers;
    }

    public Pupil[] getPupils() {
        return pupils;
    }

    /**
     * Сортировка преподавателей по предметам
     * @param dif Выбранный уровень сложности
     */
    public void teacherChoice(int dif) {
//        System.out.println("Difficulty method"); // для отладки
//        System.out.println("nameList " + nameList.size());
        Teacher temp;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10 && j < teachTemp.size(); j++) {
                temp = teachTemp.get(i * 10 + j);
                System.out.printf("%-14s" + "|", (i * 10 + j + 1));
            }
            System.out.println();
            for (int j = 0; j < 10 && j < teachTemp.size(); j++) {
                temp = teachTemp.get(i * 10 + j);
                System.out.printf("%-14s" + "|", temp.namePars[0]);
            }
            System.out.println();
            for (int j = 0; j < 10 && j < teachTemp.size(); j++) {
                temp = teachTemp.get(i * 10 + j);
                if (temp.subjects[0] == null) {
                    System.out.printf("%-14s" + "|", "пусто");
                } else {
                    System.out.printf(ANSI_BLUE + "%-14s" + "|" + ANSI_RESET, temp.subjects[0].name);
                }
            }
            System.out.println();
            for (int j = 0; j < 10 && j < teachTemp.size(); j++) {
                temp = teachTemp.get(i * 10 + j);
                if (temp.subjects[1] == null) {
                    System.out.printf("%-14s" + "|", "пусто");
                } else {
                    System.out.printf(ANSI_RED + "%-14s" + "|" + ANSI_RESET, temp.subjects[1].name);
                }
            }
            System.out.println();
            for (int j = 0; j < 10 && j < teachTemp.size(); j++) {
                temp = teachTemp.get(i * 10 + j);
                System.out.printf("Балл: %-8.3f" + "|", temp.averageCertRating);
            }
            System.out.println();
            for (int j = 0; j < 10 && j < teachTemp.size(); j++) {
                temp = teachTemp.get(i * 10 + j);
                System.out.printf("$$: %-10.2f" + "|", temp.dailyCost);
            }
            System.out.println("\n");
        }
    }

    /**
     * Формирует список ФИО из файла для дальнейшей выборки
     */
    private void nameList() {
        try {
            FileReader fr = new FileReader("NameList.txt");
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                nameList.add(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * teacherList Формирует массив преподавателей
     * @param quantity Количество преподавателей
     * @return Ссылку на массив преподавателей
     */
    private Teacher[] teacherList(int quantity) {
        Teacher[] teacherList = new Teacher[quantity];
        for (int i = 0; i < quantity; i++) {
            teacherList[i] = new Teacher(nameList.remove(i));
        }
//        System.out.println("teacherList(" + quantity + ")"); //для отладки
        return teacherList;
    }

    /**
     * pupilList Формирк=ует массив учеников
     * @param quantity Количество учеников
     * @return Ссылку на массив учеников
     */
    private Pupil[] pupilList(int quantity) {
        Pupil[] pupilList = new Pupil[quantity];
        for (int i = 0; i < quantity; i++) {
            String lit = Character.toString((char) Math.round((float) Math.random() * 3) + 1040);
            pupilList[i] = new Pupil(nameList.remove(i), "7".concat(lit));
        }
//        System.out.println("pupilList(" + quantity + ")"); // для отладки
        return pupilList;
    }

    /**
     * Формирует два массива родителей по гендерным признакам
     * @param quantity Количество родителей
     */
    private void parentList(int quantity) {
        ArrayList<Parent> parentList = new ArrayList<>();
        Parent temp;
        for (int i = quantity; i > 0; i--) {
            temp = new Parent(nameList.remove(i));
            if (temp.genderMale) {
                parentsMale.add(temp);
            } else {
                parentsFemale.add(temp);
            }
        }
//        System.out.println("parentList: male - " + parentsMale.size() + ", female - " + parentsFemale.size());
    }

    /**
     * Список семей
     * @param quantity Количество
     * @return Ссылку на список
     */
    private ArrayList<Family> familyList(int quantity) {
        ArrayList<Family> familyList = new ArrayList<>();
        Family tempFml = null;
        Parent tempM = null;
        Parent tempF = null;
        for (int i = 0; i < this.getPupils().length; i++) {
            if (i < parentsFemale.size()) {
                tempF = parentsFemale.get(i);
            } else {
                tempF = null;
            }
            if (i < parentsMale.size()) {
                tempM = parentsMale.get(i);
            } else {
                tempM = null;
            }
            tempFml = new Family(tempF, tempM, pupils[i]);
            familyList.add(tempFml);
            pupils[i].family = tempFml;
        }
//        System.out.println("familyList(" + quantity + ")"); // для отладки
        return familyList;
    }

    /**
     * Формирует массив предметов
     * @return Ссылку на массив предметов
     */
    private Subject[] subjectList() {
        Subject[] subjects = new Subject[13];
        int i = 0;
        for (Subject.Subjects s : Subject.Subjects.values()) {
            subjects[i] = new Subject(s);
//            teachers[i].setSubjects(subjects[i]);
            i++;
//            if (i == teachers.length) {
//                break;
//            }
        }

//        System.out.println("SubjectList length = " + subjects.length); // для отладки
        return subjects;
    }
}
