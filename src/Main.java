import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean ans = true;
        int num1, num2;
        char op;

        while (ans) {
            System.out.print("Enter the First Number: ");
            if (in.hasNextInt()) {
                num1 = in.nextInt();
            } else {
                System.out.println("Invalid input! Try again.");
                in.next(); // Consume invalid input
                continue;
            }
            System.out.print("Enter the Second Number: ");
            if (in.hasNextInt()) {
                num2 = in.nextInt();
            } else {
                System.out.println("Invalid input! Try again.");
                in.next(); // Consume invalid input
                continue;
            }
            System.out.print("Enter the Operator (+, -, *, /, %, q to quit): ");
            op = in.next().charAt(0);

            if (op == 'q') {
                System.out.println("Exiting calculator...");
                break;
            }

            Additon a = new Additon(num1, num2);
            Subtraction b = new Subtraction(num1, num2);
            Multiplication c = new Multiplication(num1, num2);
            Division d = new Division(num1, num2);
            Modulus m = new Modulus(num1, num2);

            try {
                switch (op) {
                    case '+' -> System.out.println("Result: " + a.add());
                    case '-' -> System.out.println("Result: " + b.sub());
                    case '*' -> System.out.println("Result: " + c.Mul());
                    case '/' -> {
                        if (num2 != 0) System.out.println("Result: " + d.div());
                        else System.out.println("Error: Cannot divide by zero!");
                    }
                    case '%' -> {
                        if (num2 != 0) System.out.println("Result: " + m.mod());
                        else System.out.println("Error: Cannot perform modulo by zero!");
                    }
                    default -> System.out.println("Invalid Operation!");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}