package HomeWork5;

public class CalculatorWithOperator implements CalculatorWith {

    public double division(double a, double b) {
        return a / b;
    }
    public double multipl(double a, double b) {
        return a * b;
    }
    public double addition(double a, double b) {
        return a + b;
    }
    public double substract(double a, double b) {
        return a - b;
    }
    public double power(double a, int power) {
        double res = 1;
        if (power == 0)
            return 1;
        for (int i = 0; i < power; i++) {
            res *= a;
        }
        return res;
    }
    public double absValue(double a) {
        if (a >= 0)
            return a;
        else
            return a *= -1;
    }
    public double sqrt(double a) {
        double res = a;
        while (res - ((res + a / res) / 2) > 0.0000001) {
            res = (res + a / res) / 2;
            System.out.println(res);
        }
        return res;
    }
}
