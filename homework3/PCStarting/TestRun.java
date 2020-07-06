package HomeWork3.PCStarting;

/**
 * Родительский (супер) класс всего проверяемого оборудования
 */
public class TestRun {
    String sysName; // Название системы (оборудования) для дочерних классов
    String mistake = ""; // Код ошибки
    boolean cleanStart = false; // Используется для запуска без ошибок в оборудовании
    int result = 0;
    boolean testStatus = false; // Результат проверки (если проверка не проводилась == негативный результат проверки)

    public String getSysName() {
        return sysName;
    }

    public String getMistake() {return mistake;}

    public void setCleanStart(boolean cleanStart) {
        this.cleanStart = cleanStart;
    }

    public boolean test() {
        result = (int) (Math.random() * 100000);
        if (result > 10000 || cleanStart) {
            testStatus = true;
            return true;
        }
        else {
            mistake = Integer.toHexString(result); // Исключительно для декорации
            testStatus = false;
            return false;
        }
    }
    public boolean run() {
        result = (int) (Math.random() * 100000);
        if (result > 5000 && testStatus || cleanStart)
            return true;
        else {
            mistake = Integer.toHexString(result); // Исключительно для декорации
            return false;
        }
    }
}
