package HomeWork1;

import java.util.Date;

public class AlarmClock {
    public static boolean sleepln(boolean weekday, boolean vacation) {
        if (weekday==false || vacation==true)
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        boolean d, v;
        v = false;
        Date date = new Date();
        if (date.getDay() > 5)
            d = false;
        else
            d = true;
        if (sleepln(d,v))
            System.out.println("Можем спать дальше!!!");
        else
            System.out.println("Пора идти на работу...(((");
    }
}