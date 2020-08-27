package sample;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("Welcome to the calculator");
        System.out.println("=========================");

        //Choose and Operator
        Calculation calculation = chooseCalculation();

        //Choose Numbers
        int[] numbers = chooseNumbers();

        //Calculate and Output Result
        int result = calculate(calculation, numbers);
        System.out.println("Result = " + result);
    }

    private static Calculation chooseCalculation() {
        System.out.println("Input your operator");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        //Perform Calculation
        switch (input) {
            case "+":
                return new Add();
            case "-":
                return new Subtract();
            case "*":
                return new Multiply();
            default:
                throw new IllegalArgumentException("You must enter an operator");
        }
    }
    private static int[] chooseNumbers() {
        //Ask for the amount of numbers
        System.out.println("How many numbers?");
        Scanner scanner = new Scanner(System.in);
        int numberAmount = scanner.nextInt();

        //Get the numbers
        int[] numbers = new int[numberAmount];
        for (int i = 1; i <= numberAmount; i++) {
            System.out.println("Input number " + i + ": ");
            numbers[i-1] = scanner.nextInt();
        }

        //return the numbers
        return numbers;
    }

    private static int calculate (Calculation calculation, int[] numbers) {
        //Calculates result
        int result = numbers[0];
        for (int j = 0; j < numbers.length-1; j++) {
            result = calculation.calculate(result, numbers[j+1]);
        }

        //Returns result
        return result;
    }
}