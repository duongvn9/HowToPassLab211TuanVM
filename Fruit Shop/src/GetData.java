import java.util.Scanner;

public class GetData {
    static Scanner sc = new Scanner(System.in);

    public static int getValidChoice(String msg, String outOfRangeMsg, int min, int max) {
        String input;
        int output = 0;
        boolean isValid = false;

        //loop until get valid input
        while (!isValid) {
            System.out.print(msg);
            input = sc.nextLine();

            //check if input is empty
            if (input.isEmpty()) {
                System.out.println("Input must not be empty. Please re-enter!");
                continue;
            }

            //handle format of input
            try {
                //convert string (output) to number (input)
                output = Integer.parseInt(input);

                //check if output is in range (from min to max)
                if (output >= min && output <= max) {
                    isValid = true;
                } else {
                    System.out.println(outOfRangeMsg);
                }
            } //catch if output is not integer
            catch (NumberFormatException e) {
                System.out.println("Input must be integer. Please re-enter!");
            }
        }

        return output;
    }

    public static String getValidString(String msg) {
        String str;
        do {
            System.out.print(msg);
            str = sc.nextLine();

            //check if empty
            if (str.isEmpty()) {
                System.out.println("Input must not be empty. Please re-enter!");
            }
        } //loop while input is empty
        while (str.isEmpty());

        return str;
    }

    public static float getValidPrice() {
        String input;
        float output = 0;
        boolean isValid = false;

        // Loop until get valid input
        while (!isValid) {
            System.out.print("Enter price: ");
            input = sc.nextLine();
            // Check if input is empty
            if (input.isEmpty()) {
                System.out.println("Input must not be empty. Please re-enter!");
                continue;
            }

            // Handle format of input
            try {
                // Convert string (output) to number (input)
                output = Float.parseFloat(input);
                // Check if output is less than 0
                if (output < 0) {
                    System.out.println("Price must not less than 0");
                } else {
                    isValid = true;
                }
            } //catch  output is not integer
            catch (NumberFormatException e) {
                System.out.println("Input must be float. Please re-enter!");
            }
        }

        return output;
    }

    public static int getValidQuantity() {
        String input;
        int output = 0;
        boolean isValid = false;

        // Loop until get valid input
        while (!isValid) {
            System.out.print("Enter quantity: ");
            input = sc.nextLine();
            // Check if input is empty
            if (input.isEmpty()) {
                System.out.println("Input must not be empty. Please re-enter!");
                continue;
            }

            // Handle format of input
            try {
                // Convert string (output) to number (input)
                output = Integer.parseInt(input);
                // Check if output is less than 0
                if (output < 0) {
                    System.out.println("Quantity must not less than 0");
                } else {
                    isValid = true;
                }
            } //catch if output is not integer
            catch (NumberFormatException e) {
                System.out.println("Input must be integer. Please re-enter!");
            }
        }

        return output;
    }

    public static String getValidConfirm() {
        String input = "";
        boolean isValid = false;

        // Loop until get valid input
        while (!isValid) {
            System.out.print("Please confirm: ");
            input = sc.nextLine();
            // Check if empty
            if (input.isEmpty()) {
                System.out.println("Input must not be empty. Please re-enter!");
                continue;
            }

            // Check if input is Y or N
            if (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("N")) {
                isValid = true;
            } else {
                System.out.println("Wrong confirm. Please re-enter Y or N!");
                isValid = false;
            }
        }

        return input;
    }
}
