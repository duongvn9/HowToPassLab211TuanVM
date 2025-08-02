package program;

import java.util.Scanner;

class InputUtils {

    private static final Scanner sc = new Scanner(System.in);

    // method to check input value of choice in menu
    public static int inputChoice() {
        while (true) {
            System.out.print("Please choice one option: ");
            try {
                // get input string from user and remove space
                String input = sc.nextLine();

                // check if input is null
                if (input.isEmpty()) {
                    System.out.println("Input cannot null. Please enter again.");
                    // loop until user enter any thing
                    continue;
                }

                int choice = Integer.parseInt(input);
                // check if user input number out of range 1 to 3
                if (choice < 1 || choice > 3) {
                    System.out.println("Please input a number in range [1,3]");
                } else {
                    return choice;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please input a number in range [1,3]");
            }
        }
    }

    // method to check valid of input number in normal calculator
    public static double inputDoubleNumber() {
        String input;
        double number = 0;

        //loop until user input valid double number
        while (true) {
            try {
                System.out.print("Enter number: ");
                input = sc.nextLine();

                // check if input is null
                if (input.isEmpty()) {
                    System.out.println("Input can not null. Please enter again.");
                    // loop until user enter any thing
                    continue;
                }

                // convert string to double number
                number = Double.parseDouble(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please input a double number.");
            }
        }

        return number;
    }

    public static Operator inputOperator() {
        String stringOperator;
        // loop until user input valid operator
        while (true) {
            System.out.print("Enter Operator: ");

            stringOperator = sc.nextLine().trim();

            Operator op = null;

            // check input operator
            switch (stringOperator) {
                case "+":
                    op = Operator.ADD;
                    break;
                case "-":
                    op = Operator.SUBTRACT;
                    break;
                case "*":
                    op = Operator.MULTIPLY;
                    break;
                case "/":
                    op = Operator.DIVIDE;
                    break;
                case "^":
                    op = Operator.POWER;
                    break;
                case "=":
                    op = Operator.EQUAL;
                    break;
            }

            // check if user dont input anything
            if (op == null) {
                System.out.println("Please input (+, -, *, /, ^, =)");
            } else {
                return op;
            }
        }
    }

    // method to get valid of weight
    public static double inputDoubleWeight() {
        String input;
        double weight = 0;

        //loop until user input valid double number
        while (true) {
            try {
                System.out.print("Enter Weight(kg): ");
                input = sc.nextLine();

                // Check if input is null
                if (input.isEmpty()) {
                    System.out.println("Input can not null. Please enter again.");
                    // loop until user enter any thing
                    continue;
                }

                // convert string to double number
                weight = Double.parseDouble(input);

                // check if number is smaller 0
                if (weight <= 0) {
                    System.out.println("Please enter positive number!");
                    // loop until user input a digit
                    continue;
                }
                // if input valid double number break
                break;
            } catch (NumberFormatException e) {
                System.out.println("BMI is digit");
            }
        }
        return weight;
    }

    // method to get valid of Height
    public static double inputDoubleHeight() {
        String input;
        double height = 0;

        //loop until user input valid double number
        while (true) {
            try {
                System.out.print("Enter Height(cm): ");
                input = sc.nextLine();

                // check if input is null
                if (input.isEmpty()) {
                    System.out.println("Input can not null. Please enter again.");
                    // loop until user enter any thing
                    continue;
                }

                // convert string to double number
                height = Double.parseDouble(input);

                // check if number is <= 0
                if (height <= 0) {
                    System.out.println("Please enter positive number!");
                    // loop until user input a digit
                    continue;
                }
                // if input valid double number break
                break;
            } catch (NumberFormatException e) {
                System.out.println("BMI is digit");
            }
        }
        return height;
    }
}
