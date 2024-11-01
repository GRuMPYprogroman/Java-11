package calculator;

public final class Calculator {    

    private Calculator() {}

    public static double calculate(double firstNumber,double secondNumber,char operation){
        switch(operation)
        {
            case '+':
                return firstNumber + secondNumber;
            case '-':
                return firstNumber - secondNumber;
            case '*':
                return firstNumber * secondNumber;
            case '/':
                if ( secondNumber == 0){
                    throw new ArithmeticException("Cannot divide by zero!");
                }
                return firstNumber / secondNumber;
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }
    
}
