package HomeWork3.PCStarting;

import java.util.concurrent.TimeUnit;

public class PCStart {
    public static void main(String[] args) throws InterruptedException {
        IPCStart[] start = new IPCStart[8];
        start[0] = new CP();
        start[1] = new ContrSumm();
        start[2] = new FirstBytes();
        start[3] = new VGA();
        start[4] = new RAM();
        start[5] = new Bios();
        start[6] = new COMport();
        start[7] = new Flopp();
        boolean cleanStart = false;   // Для старта без ошибок установить равным true
        /**
         * Последовательно тестируются и запускаются все системы
         */
        for (int i = 0; i < start.length; i++) {
            start[i].setCleanStart(cleanStart);
            if (!start[i].test()) {
                System.out.println("Тест системы \"" + start[i].getSysName() + "\" прерван.\nКод оБшиБки: " +
                        start[i].getMistake() + ".\nДальнейшая загрузка невозможна.");
                return;
            }
            else {
                System.out.println("Тестирование системы \"" + start[i].getSysName() + "\" завершено успешно.");
                Thread.sleep(1000);
            }
            if (!start[i].run()) {
                System.out.println("Возникла оБшиБка во время загрузки системы \"" + start[i].getSysName() +
                        "\"\nКод оБшиБки: " + start[i].getMistake() + ".\nДальнейшая загрузка невозможна.");
                return;
            }
            else {
                System.out.println("Загрузка системы \"" + start[i].getSysName() +  "\" завершена успешно.");
                Thread.sleep(1000);
            }
        }
        /**
         * Если все тесты пройдены успешно, и все системы загнужены, запускается ОС
         */
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_SOLID = "\033[1m";
        final String ANSI_RESET = "\u001B[0m";
        Thread.sleep(1000);
        System.out.print("OS starting");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(200);
            System.out.print(".");
        }
        System.out.println();
        if ((int) (Math.random() * 10) < 2) {
            for (int i = 0; i < 4; i++)
            System.out.println(ANSI_BLUE + "###############################################");
            System.out.println("####################       ####################");
            System.out.println("##################   ERROR   ##################");
            System.out.println("####################       ####################");
            for (int i = 0; i < 4; i++)
            System.out.println("###############################################");
            System.out.println(ANSI_RESET + "Error code: " + Integer.toHexString((int) (Math.random() * 100000)));
            return;
        }
        System.out.println(ANSI_SOLID + "Hello MAN!!!");
    }
}
