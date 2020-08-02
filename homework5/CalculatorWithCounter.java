package HomeWork5;

import java.util.Objects;

public class CalculatorWithCounter {
    private CalculatorGen calculatorGen = null;
    private int countOperation =0;

    public CalculatorWithCounter (CalculatorWithOperator calc) {
        calculatorGen = new CalculatorGen<>();
        calculatorGen.setItem(calc);
    }

    public CalculatorWithCounter (CalculatorWithMathCopy calc) {
        calculatorGen = new CalculatorGen<>();
        calculatorGen.setItem(calc);
    }

    /**
     * Для объекта класса CalculatorWithMathExtends отдельный конструктор не нужен, т.к. он является
     * дочерним объектом класса CalculatorWithOperator и будет работать с конструктором для него
     */

    public double division (double a, double b) {
        incCountOperation();
        return calculatorGen.getItem().division(a, b);
    }
    public double multipl (double a, double b) {
        incCountOperation();
        return calculatorGen.getItem().multipl(a, b);
    }
    public double addition (double a, double b) {
        incCountOperation();
        return calculatorGen.getItem().addition(a, b);
    }
    public double substract (double a, double b) {
        incCountOperation();
        return calculatorGen.getItem().substract(a, b);
    }
    public double power (double a, int power) {
        incCountOperation();
        return calculatorGen.getItem().power(a, power);
    }
    public  double absValue (double a) {
        incCountOperation();
        return calculatorGen.getItem().absValue(a);
    }
    public double sqrt (double a) {
        incCountOperation();
        return calculatorGen.getItem().sqrt(a);
    }

    public int getCountOperation() {
        return countOperation;
    }

    public void incCountOperation() {
        countOperation++;
    }
}
