package sample;
import java.util.Random;
import java.util.Scanner;

public class Calculator {
    public static void main (String[] args) {
        System.out.println("Welcome to the calculator");

        //Generate 2 random number
        Random random = new Random();
        int randomNum1 = random.nextInt(100);
        int randomNum2 = random.nextInt(100);

        //Choose an operator
        System.out.println("Input your operator");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        //Perform calculation
        if (input.equals("+")) {
            System.out.println(randomNum1 + randomNum2);
        }
        else if (input.equals("-")) {
            System.out.println(randomNum1 - randomNum2);
        }
        else if (input.equals("*")) {
            System.out.println(randomNum1 * randomNum2);
        }
        else {
            System.out.println("Invalid input");
        }
    }
}
