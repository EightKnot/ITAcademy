package FinalApp;

public class Pupil{
    String name;
    String nameStrip;
    String classNumber;
    Family family;
    Double averageBehaviorRating;
    Double averageProgressRating;
    boolean latenessTendency;
    int baseIQ;
    boolean hiddenPotential;
    Double dailyIncome;

    Pupil(String name, String classNumber) {
        this.name = name;
//        this.nameStrip = name.replaceAll("\\s+", ""); // заменить
        this.classNumber = classNumber;
        this.averageBehaviorRating = Math.random() * 10;
        this.averageProgressRating = Math.random() * 10;
        if (Math.random() < 0.5) {
            this.latenessTendency = true;
        } else {
            this.latenessTendency = false;
        }

        this.baseIQ = (int) (Math.random() * (160 - 60)) + 60;

        if (Math.random() < 0.5) {
            this.hiddenPotential = true;
        } else {
            this.hiddenPotential = false;
        }
    }
    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) throws Exception {
        if (classNumber.matches("^([1-9]|10|11)[А-Я]$")) {
            this.classNumber = classNumber;
        } else {
            throw new Exception("Incorrect class name format (must be between 1А and 11Я)");
        }
    }

    public Double getAverageBehaviorRating() {
        return averageBehaviorRating;
    }

    public void setAverageBehaviorRating(Double averageBehaviorRating) {
        this.averageBehaviorRating = averageBehaviorRating;
    }

    @Override
    public String toString() {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_SOLID = "\033[1m";
        final String ANSI_RESET = "\u001B[0m";
        return "Pupil{" +
                ANSI_BLUE + "name='" + name + '\'' +
                ANSI_RESET + ", nameStrip='" + nameStrip + '\'' +
                ANSI_BLUE + ", classNumber='" + classNumber + '\'' + "\n" +
                ANSI_RESET + ", averageBehaviorRating=" + String.format("%.3f",averageBehaviorRating) +
                ", averageProgressRating=" + String.format("%.3f",averageProgressRating) +
                ", latenessTendency=" + latenessTendency +
                ANSI_SOLID + ", baseIQ=" + baseIQ +
                ANSI_RESET + ", hiddenPotential=" + hiddenPotential +
                '}';
    }
}
