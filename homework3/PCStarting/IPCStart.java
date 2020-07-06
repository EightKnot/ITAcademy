package HomeWork3.PCStarting;

public interface IPCStart {
    boolean test();
    boolean run();
    String getSysName(); // Название системы (оборудования) для дочерних классов
    String getMistake(); // Возвращает код ошибки
    void setCleanStart(boolean cleanStart); // Используется для запуска без ошибок в оборудовании
}
