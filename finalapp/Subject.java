package FinalApp;

public class Subject {
    String name;
    Teacher[] teacher;
    enum Subjects {
        BIOLOGY ("Биология"),
        CHEMISTRY ("Химия"),
        COMPUTER_SCIENCE ("Информатика"),
        CULTURAL_STUDIES ("Культурология"),
        ECOLOGY ("Экология"),
        ENGLISH ("Английский"),
        GEOGRAPHY ("География"),
        HISTORY ("История"),
        LITERATURE ("Литература"),
        MATHEMATICS ("Математика"),
        PHYSICAL_EDUCATION ("Физкультура"),
        PHYSICS ("Физика"),
        TECHNOLOGY ("Труды");

        private String title;

        Subjects(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }

    public Subject() {
        this.name = "";
        this.teacher = new Teacher[2];
    }
    public Subject(Subjects subject) {
        this.name = subject.getTitle();
        this.teacher = new Teacher[2];
    }
    public Subject(Subjects subject, Teacher teacher) {
        this.name = subject.getTitle();
        this.teacher[0] = teacher; // дописать обработчик
    }

    @Override
    public String toString() {
        String ret = "Subject{subject=".concat(this.name);
        for (int i = 0; i < 2; i++) {
            if (this.teacher[i].nameWholly != null) {
                ret = ret.concat("; teacher=" + this.teacher[i].nameWholly);
            }
        }
        ret = ret.concat("}");
        return ret;
    }
}
