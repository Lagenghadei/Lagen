import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1, num2, result;
        char operator;
        
        System.out.println("Simple Calculator");
        System.out.println("Enter first number: ");
        num1 = scanner.nextDouble();
        
        System.out.println("Enter an operator (+, -, *, /): ");
        operator = scanner.next().charAt(0);
        
        System.out.println("Enter second number: ");
        num2 = scanner.nextDouble();
        
        switch (operator) {
            case '+':
                result = num1 + num2;
                System.out.println("The result is: " + result);
                break;
            case '-':
                result = num1 - num2;
                System.out.println("The result is: " + result);
                break;
            case '*':
                result = num1 * num2;
                System.out.println("The result is: " + result);
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                    System.out.println("The result is: " + result);
                } else {
                    System.out.println("Error! Division by zero.");
                }
                break;
            default:
                System.out.println("Invalid operator!");
                break;
        }
        
        scanner.close();
    }
}
