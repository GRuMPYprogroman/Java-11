package calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        System.out.print("Enter two numbers(a,b) and operation to do (ex.: a b +) ");
        double a = console.nextDouble(); 
        double b = console.nextDouble(); 
        char operation = console.next().charAt(0);

        System.out.println("Result: " + Calculator.calculate(a,b,operation));
        console.close();
    }
}
