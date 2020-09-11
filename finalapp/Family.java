package FinalApp;

public class Family {
    Parent mother;
    Parent father;
    Pupil children;
    double familyBudget = 600;
    double dailyBudgetIncome;
    double baseSalary = 900;

    public Family(Parent mother, Parent father, Pupil pupil) {
        this.mother = mother;
        this.father = father;
        this.children = pupil;
        if (this.mother != null && this.father != null) {
            this.dailyBudgetIncome = baseSalary / 30 * 2;
        } else {
            this.dailyBudgetIncome = baseSalary / 30;
        }
    }

    @Override
    public String toString() {
        String tmpF = null;
        String tmpM = null;
        if (this.mother != null) {
            tmpF = mother.nameWholly;
        } else {
            tmpF = "no";
        }
        if (this.father != null) {
            tmpM = father.nameWholly;
        } else {
            tmpM = "no";
        }
        return "Family{" +
                "mother=" + tmpF +
                ", father=" + tmpM +
                ", children=" + this.children.name +
                ", familyBudget=" + familyBudget +
                ", dailyBudgetIncome=" + dailyBudgetIncome +
                '}';
    }
}
