package FinalApp;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class SchoolMain {
    public static void main(String[] args) {
        String playerName = "";
        int difficulty = 0;
        int teachersSource = 0; // количество соискателей на должности преподавателей

        GamePlay gamePlay = new GamePlay();

        Scanner scanner = new Scanner(System.in);
        String playerInput = "";
        System.out.println("Поздравляем с назначением на должность директора нашей школы!!\nПредставьтесь, пожалуйста:");
        playerName = scanner.next();
        System.out.println("Здравствуйте, " + playerName + "!");
        do {
            System.out.println("Выберите режим игры:\n(Легко - 1, Средне - 2, Сложно - 3):");
            playerInput = scanner.next();
            if (playerInput.matches("(1|2|3)")) {
                difficulty = Integer.parseInt(playerInput);
                break;
            }
        } while (playerInput.toLowerCase().compareTo("exit") != 0);

        switch (difficulty) {
            case 1:
                teachersSource = 25;
                break;
            case 2:
                teachersSource = 17;
                break;
            case 3:
                teachersSource = 10;
                break;
        }

        /**
         * Распределение преподавателей по предметам в ручном режиме
         */
        int temp = 0;
        for (Subject subject : gamePlay.subjects) {
            do {
                gamePlay.teacherChoice(difficulty);
                System.out.println("Выберите преподавателя для предмета " + subject.name + ":");
                temp = scanner.nextInt() - 1;
                if (temp < 0 || temp > gamePlay.numberOfСandidates - 1) {continue;}
                if (gamePlay.teachTemp.get(temp).subjects[0] == null) {
                    gamePlay.teachTemp.get(temp).subjects[0] = subject;
                } else if (gamePlay.teachTemp.get(temp).subjects[1] == null) {
                    gamePlay.teachTemp.get(temp).subjects[1] = subject;
                } else {continue;}

                if (subject.teacher[0] == null) {
                    subject.teacher[0] = gamePlay.teachTemp.get(temp);
                } else if (subject.teacher[1] == null) {
                    subject.teacher[1] = gamePlay.teachTemp.get(temp);
                } else {continue;}
                break;
            } while (true);
        }
        // для отладки
/*        System.out.println(gamePlay.teachers.length);
        gamePlay.teachers[0].printData();
        gamePlay.teachers[1].printData();
        gamePlay.teachers[2].printData();
        System.out.println(gamePlay.teachers[2].toString());
        System.out.println(gamePlay.nameList.size());
        for (int i = 0; i < 10; i++) {
            System.out.println(gamePlay.parentsMale.get(i));
            System.out.println(gamePlay.parentsFemale.get(i));
        }
        System.out.println(gamePlay.nameList.size());
        for (int i = 0; i < 10; i++) {
            System.out.println(gamePlay.families.get(i));
        }*/


/*        for (Pupil pupil : pupilList) {
            System.out.println(pupil.toString());
        }

        try {
            pupilList[1].setClassNumber("5В");
            pupilList[2].setClassNumber("21В");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(pupilList[1].toString() + "\n" + pupilList[2].toString());
        for (Subject subject : gamePlay.subjects) {
            System.out.println(subject);
        }*/
    }
}
