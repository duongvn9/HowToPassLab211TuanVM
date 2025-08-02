package changebase;

import java.util.Scanner;

class InputUtils {
    static Scanner sc = new Scanner(System.in);

    public static int getValidBase(String msg) {
        String input;
        int number;
        // loop infinity
        while (true) {
            try {
                System.out.println(msg + " 1 is binary, 2 is decimal, 3 is hexadecimal:");
                input = sc.nextLine();
                // check if input is empty
                if (input.isEmpty()) {
                    System.out.println("Input can not null. Please enter again!");
                    // loop until get string input
                    continue;
                }
                number = Integer.parseInt(input);
                // check if input is out of range [1;3]
                if (number < 1 || number > 3) {
                    System.out.println("Please input number in range [1,3];");
                    // loop until get valid number
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please input number in range [1,3];");
            }
        }
        return number;
    }

    public static String getValidValue(int baseInput) {
        String input = "";
        boolean isValid = false;
        // loop infinity
        while (!isValid) {
            System.out.print("Please enter input value: ");
            input = sc.nextLine();
            // check if input is empty
            if (input.isEmpty()) {
                System.out.println("Input can not null. Please enter again!");
                // loop until get string input
                continue;
            }
            isValid = BaseConverter.checkFormatByBaseNumber(input, baseInput);
        }
        return input;
    }

    public static int getValidChoice() {
        String input;
        int number;
        // loop infinity
        while (true) {
            try {
                input = sc.nextLine();
                // check if input is empty
                if (input.isEmpty()) {
                    System.out.println("Input can not null. Please enter again!");
                    // loop until get string input
                    continue;
                }
                number = Integer.parseInt(input);
                // check if input is not 0 or 1
                if (number < 0 || number > 1) {
                    System.out.println("Please input only 0 or 1. 1 is Yes, 0 is No");
                    // loop until get valid number
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please input only 0 or 1. 1 is Yes, 0 is No");
            }
        }
        return number;
    }
}
