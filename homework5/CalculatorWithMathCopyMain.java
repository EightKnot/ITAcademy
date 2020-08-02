package HomeWork5;

public class CalculatorWithMathCopyMain {
    public static void main(String[] args) {
        double res = 0;
        CalculatorWithMathCopy calculator = new CalculatorWithMathCopy();

        res = calculator.division(28, 5);
        res = calculator.power(res, 2);
        res = calculator.addition(res, calculator.multipl(15, 7));
        res = calculator.addition(res,4.1);

        System.out.println(res);

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
            System.out.println(e.getMessage());
        }

        System.out.println(calculator.division(res, 0.0d));
    }
}
