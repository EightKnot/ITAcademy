package HomeWork5;

public class CalculatorWithMathExtends extends CalculatorWithOperator {
    @Override
    public double power(double a, int power) {
        return Math.pow(a, power);
    }

    @Override
    public double absValue(double a) {
        return Math.abs(a);
    }

    @Override
    public double sqrt(double a) {
        return Math.sqrt(a);
    }
}
