import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        double result = 0;
        if (args.length > 0) {
            try {
                result = Double.parseDouble(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid initial value, using default 0");
            }
        }
        System.out.println("Initial value: " + result);
        System.out.println("Enter an operator (+, -, *, /) followed by a number,one under the other:");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String operator = scanner.next();
            if (!operator.matches("[+\\-*/]")) {
                System.out.println("Invalid operator, please enter +, -, *, or /");
                continue;
            }
            if (!scanner.hasNextDouble()) {
                System.out.println("Invalid number, please enter a valid double");
                continue;
            }
            double number = scanner.nextDouble();
            switch (operator) {
                case "+":
                    result += number;
                    break;
                case "-":
                    result -= number;
                    break;
                case "*":
                    result *= number;
                    break;
                case "/":
                    if (number == 0) {
                        System.out.println("Error: division by zero");
                        continue;
                    }
                    result /= number;
                    break;
            }
            System.out.println("Result: " + result);
        }
    }
}
