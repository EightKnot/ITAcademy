package HomeWork5;

public class CalculatorWithMemoryMain {
    public static void main(String[] args) {
        double res = 0;
        CalculatorWithMemory calculator = new CalculatorWithMemory(new CalculatorWithMathExtends());

        calculator.setMemory(calculator.division(28, 5));
        calculator.setMemory(calculator.power(calculator.getMemory(), 2));
        calculator.setMemory(calculator.addition(calculator.getMemory(), calculator.multipl(15, 7)));
        calculator.setMemory(calculator.addition(calculator.getMemory(),4.1));
        res = calculator.getMemory();
        System.out.println("Результат вычислений: " + res);

        /**
         * Ошибок при делении на 0 не возникало, т.к. делилось число типа double. Результат такого деления - бесконечность.
         * А при делении интового числа на 0, по умолчанию интовый, возникает исключение, прекращающее выполнение программы,
         * если его не словить и не обработать.
         * При делении целочисленного значения на 0 типа double, получаем результат типа double, т.е. бесконечность.
         */
        System.out.println(calculator.division(res, 0));

        try {
            System.out.println(5 / 0);
        } catch (ArithmeticException e) {
            System.out.println(e);
        }

        System.out.println(calculator.division(res, 0.0d));
        System.out.println("Количество выполненных математических действий: " + calculator.getCountOperation());
    }
}
