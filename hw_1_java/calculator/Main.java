package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        boolean continueProgram = true;

        while (continueProgram) {
            try {
                System.out.print("Enter two numbers (a b) and operation to do (ex.: a b +), or type 'exit' to quit: ");

                if (console.hasNext("exit")) {
                    continueProgram = false;
                    break;
                }

                double a = console.nextDouble();
                double b = console.nextDouble();
                char operation = console.next().charAt(0);

                double result = Calculator.calculate(a, b, operation);
                System.out.println("Result: " + result);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numeric values for numbers.");
                console.nextLine();
            } catch (ArithmeticException e) {
                System.out.println("Arithmetic error: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }

        console.close();
    }
}
