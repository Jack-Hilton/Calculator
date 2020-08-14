package sample;
import java.util.Random;
import java.util.Scanner;

public class Calculator {
    public static void main (String[] args) {
        System.out.println("Welcome to the calculator");

        //Generate 2 random numbers
        /*Random random = new Random();
        int randomNum1 = random.nextInt(100);
        int randomNum2 = random.nextInt(100);*/

        //Choose Number 1
        System.out.println("Input your first number");
        Scanner scanner = new Scanner(System.in);
        int num1 = Integer.valueOf(scanner.next());

        //Choose Number 2
        System.out.println("Input your second number");
        int num2 = Integer.valueOf(scanner.next());

        //Choose an operator
        System.out.println("Input your operator");
        String input = scanner.next();

        //Perform calculation
        if (input.equals("+")) {
            int result = num1 + num2;
            System.out.println(num1 + " + " + num2 + " = " + result);
        }
        else if (input.equals("-")) {
            int result = num1 - num2;
            System.out.println(num1 + " - " + num2 + " = " + result);
        }
        else if (input.equals("*")) {
            int result = num1 * num2;
            System.out.println(num1 + " * " + num2 + " = " + result);
        }
        else {
            System.out.println("Invalid input");
        }
    }
}
