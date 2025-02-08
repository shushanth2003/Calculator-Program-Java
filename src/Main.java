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

            Additon a = new Additon();
            Subtraction b = new Subtraction();
            Multiplication c = new Multiplication();
            Division d = new Division();
            Modulus m = new Modulus();

            try {
                switch (op) {
                    case '+' -> System.out.println("Result: " + a.perform(num1,num2));
                    case '-' -> System.out.println("Result: " + b.perform(num1,num2));
                    case '*' -> System.out.println("Result: " + c.perform(num1,num2));
                    case '/' -> {
                        if (num2 != 0) System.out.println("Result: " + d.perform(num1,num2));
                        else System.out.println("Error: Cannot divide by zero!");
                    }
                    case '%' -> {
                        if (num2 != 0) System.out.println("Result: " + m.perform(num1,num2));
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