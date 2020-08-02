package HomeWork5;

public class CalculatorWithMathCopy implements CalculatorWith {
    public double division (double a, double b) {
        return a / b;
    }
    public double multipl (double a, double b) {
        return a * b;
    }
    public double addition (double a, double b) {
        return a + b;
    }
    public double substract (double a, double b) {
        return a - b;
    }
    public double power (double a, int power) {
        return Math.pow(a, power);
    }
    public  double absValue (double a) {
        return Math.abs(a);
    }
    public double sqrt (double a) {
        return Math.sqrt(a);
    }
}
