package sample;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("Welcome to the calculator");
        System.out.println("=========================");

        //Choose an Operator
        Calculation calculation = chooseCalculation();

        //Choose Numbers
        List<Integer> numbers = chooseNumbers();

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
    private static List<Integer> chooseNumbers() {
        //Get First Number and Create List
        System.out.println("Input a number: ");
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        while (scanner.hasNextInt()) {
            numbers.add(scanner.nextInt());
            System.out.println("Input your next number or 'done': ");
        }

        //return the numbers
        return numbers;
    }

    private static int calculate (Calculation calculation, List<Integer> numbers) {
        //Calculates result
        int result = numbers.get(0);
        for (int j = 0; j < numbers.size()-1; j++) {
            result = calculation.calculate(result, numbers.get(j+1));
        }

        //Returns result
        return result;
    }
}