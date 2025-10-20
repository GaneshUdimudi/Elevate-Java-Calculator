import java.util.Scanner;

public class Calculator {

    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public static double divide(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Error: Cannot divide by zero. Operation skipped.");
            return num1;
        }
        return num1 / num2;
    }

    public static double modulus(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Error: Cannot perform modulus by zero. Operation skipped.");
            return num1;
        }
        return num1 % num2;
    }

    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public static double square(double num) {
        return num * num;
    }

    public static double squareRoot(double num) {
        if (num < 0) {
            System.out.println("Error: Cannot calculate the square root of a negative number.");
            return num;
        }
        return Math.sqrt(num);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double currentResult = 0;

        System.out.print("Enter starting number: ");
        currentResult = scanner.nextDouble();

        while (true) {
            System.out.println("\nCurrent Result: " + currentResult);
            System.out.print("Enter operator (+, -, *, /, %, ^, sqrt, sq), 'c' to clear, or 'q' to quit: ");
            String operator = scanner.next();

            if (operator.equalsIgnoreCase("q")) {
                System.out.println("Final Result: " + currentResult);
                break;
            }

            if (operator.equalsIgnoreCase("c")) {
                System.out.print("Enter starting number: ");
                currentResult = scanner.nextDouble();
                continue;
            }
            
            switch (operator.toLowerCase()) {
                case "sq":
                    currentResult = square(currentResult);
                    continue;
                case "sqrt":
                    currentResult = squareRoot(currentResult);
                    continue;
            }

            System.out.print("Enter next number: ");
            double nextNumber = scanner.nextDouble();

            switch (operator) {
                case "+":
                    currentResult = add(currentResult, nextNumber);
                    break;
                case "-":
                    currentResult = subtract(currentResult, nextNumber);
                    break;
                case "*":
                    currentResult = multiply(currentResult, nextNumber);
                    break;
                case "/":
                    currentResult = divide(currentResult, nextNumber);
                    break;
                case "%":
                    currentResult = modulus(currentResult, nextNumber);
                    break;
                case "^":
                    currentResult = power(currentResult, nextNumber);
                    break;
                default:
                    System.out.println("Invalid operator. Please try again.");
                    break;
            }
        }
        scanner.close();
    }
}