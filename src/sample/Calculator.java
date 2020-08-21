package sample;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("Welcome to the calculator");

        //Choose Number 1
        System.out.println("Input your first number");
        Scanner scanner = new Scanner(System.in);
        int num1 = Integer.valueOf(scanner.next());

        //Choose Number 2
        System.out.println("Input your second number");
        int num2 = Integer.valueOf(scanner.next());

        //Choose and Operator
        Calculation calculation = chooseCalculation();

        //Calculate and Output Result
        int result = calculation.calculate(num1, num2);
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
}