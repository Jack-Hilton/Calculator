package sample;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.io.File;
import java.io.FileWriter;

public class Calculator {
    private static final String RESULT_LOGGER = "resultLogger.log";

    public static void main(String[] args) {
        System.out.println("Welcome to the calculator");
        System.out.println("=========================");

        while (true) {
            //Choose an Operator
            Calculation calculation = null;
            try {
                calculation = chooseCalculation();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            //Read File to Get Numbers
            List<Integer> numbers = null;
            try {
                numbers = readNumbers();
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
                continue;
            }

            //Calculate Result
            int result = calculate(calculation, numbers);

            //Write to File and Print Result
            try {
                writeResult(result);
            } catch (IOException e) {
                System.out.println("Could not write to file");
            }
            System.out.println("Result = " + result);

            System.out.println("Perform another calculation? (y/n)");
            Scanner scanner = new Scanner(System.in);
            if (!scanner.next().startsWith("y")) {
                break;
            }
        }
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

    private static List<Integer> readNumbers() throws FileNotFoundException {
        //Asks user for file name
        System.out.println("Enter a file: ");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.next();

        //Reads File
        File file = new File(fileName);
        try (Scanner fileScanner = new Scanner(file)) {
            List<Integer> numbers = new ArrayList<>();

            //Adds Next Number to the List
            while (fileScanner.hasNext()) {
                numbers.add(Integer.valueOf(fileScanner.next()));
            }

            //Returns the List
            return numbers;
        }
    }

    private static void writeResult (int result) throws IOException {
        try (FileWriter fileWriter = new FileWriter(RESULT_LOGGER, true)) {
            fileWriter.write("Result: " + result + "\n");
        }
    }
}