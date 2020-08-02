package HomeWork5;

public class CalculatorWithMemory {
    private CalculatorGen calculatorGen = null;
    private int countOperation =0;
    private double memory = 0;

    public CalculatorWithMemory(CalculatorWithOperator calc) {
        calculatorGen = new CalculatorGen<>();
        calculatorGen.setItem(calc);
    }

    public CalculatorWithMemory(CalculatorWithMathCopy calc) {
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

    public double getMemory() {
        double temp = memory;
        memory = 0;
        return temp;
    }

    public void setMemory(double memory) {
        this.memory = memory;
    }
}
