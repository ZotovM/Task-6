import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        double x = readNum("Значение х: ");
        if (isValueOfXPositive(x)) {
            System.out.print("Введенное значение должно соответствовать условию: (-1 <= x <= 1) ");
            return;
        }

        double n = readNum("Значение n: ");
        if (isValueOfNPositive(n)) {
            System.out.print("Введенное значение n не должно быть меньше нуля! ");
            return;
        }

        double e = readNum("Значение е: ");
        double sumOfNSummand = calculateSumOfNSummand(x, n);
        double valueOfFunctionUsedByMath = calculateValueOfFunctionUsedByMath(x);
        double sumOfSummandOverThanE = calculateSumOfSummandOverThanE(x, n, e);
        double sumOfSummandOverThanEDividedBy10 = calculateSumOfSummandOverThanE(x, n, e/10);

        printResult(sumOfNSummand, valueOfFunctionUsedByMath, sumOfSummandOverThanE, sumOfSummandOverThanEDividedBy10);

    }

    private static double calculateSumOfNSummand(double x, double n) {
        double sumOfSequence = 1;
        double an = 1;

        for (int i = 1; i <= n; i++) {
            an = (an * (2 * i - 1) / (2 * i)) * Math.pow(x, 2);
            sumOfSequence += an;
        }
        return sumOfSequence;
    }

    private static double calculateSumOfSummandOverThanE(double x, double n, double e) {
        double term;
        double sum = 0;
        double an = 1;

        for (int i = 1; i <= n; i++) {
            term = (an * (2 * i - 1) / (2 * i)) * Math.pow(x, 2);

            if (term > e) {
                sum += term;
            }
        }
        return sum;

    }

    private static void printSumOfNSummand(double sumOfNSummand) {
        System.out.println("Сумма N последовательности равна: " + sumOfNSummand);
    }

    private static void printSumOfNSummandOverThanE(double sumOfNSummandOverThanE) {
        System.out.println("Сумма последовательности N, большая чем E: " + sumOfNSummandOverThanE);
    }

    private static void printSumOfNSummandOverThanEDividedBy10(double sumOfNSummandOverThanEDividedBy10) {
        System.out.println("Сумма последовательности N, большая чем E/10: " + sumOfNSummandOverThanEDividedBy10);
    }


    private static double calculateValueOfFunctionUsedByMath(double x) {
        return 1 / Math.sqrt(1- Math.pow(x, 2));
    }

    private static void printValueOfFunctionUsedByMath(double valueOfFunctionUsedByMath) {
        System.out.println("Значение функции: " + valueOfFunctionUsedByMath);
    }

    private static void printResult(double sumOfNSummand, double valueOfFunctionUsedByMath,
                                    double sumOfSummandOverThanE, double sumOfSummandOverThanEDividedBy10) {
        printSumOfNSummand(sumOfNSummand);
        printValueOfFunctionUsedByMath(valueOfFunctionUsedByMath);
        printSumOfNSummandOverThanE(sumOfSummandOverThanE);
        printSumOfNSummandOverThanEDividedBy10(sumOfSummandOverThanEDividedBy10);
    }

    private static boolean isValueOfXPositive (double num) {
        return num < -1 || num > 1;
    }

    private static boolean isValueOfNPositive (double num) {
        return num < 0;
    }

    private static double readNum (String value) {
        System.out.print("Введите " + value);
        Scanner scn = new Scanner(System.in);
        return scn.nextDouble();
    }

}
