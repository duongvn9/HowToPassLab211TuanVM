import java.util.Scanner;
public class LinearSearch {
    public static void main(String[] args) {
        // Step 1: Input number of array
        int length = inputValidNumber("Enter number of array:");

        // Step 2: Input search number
        int searchNumber = inputValidNumber("Enter search value:");

        // Step 3: Generate random integer array
        int[] randomIntegerArray = generateIntegerArray(length);

        // Step 4: Display array
        displayArray(randomIntegerArray);

        // Step 5: Display index of search number
        displayIndex(searchNumber, randomIntegerArray);
    }

    private static int inputValidNumber(String message) {
        Scanner sc = new Scanner(System.in);
        boolean isValid = false;
        String input;
        int number = -1;

        //use loop until input is valid
        while (!isValid) {
            System.out.println(message);
            input = sc.nextLine();

            // Check if input is empty
            if (input.isEmpty()) {
                System.out.println("Input must not be empty. Please re-enter!");
                continue;
            }
            // Handle format of input
            try {
                number = Integer.parseInt(input);

                // Check if the number is greater than 0
                if (number > 0) {
                    isValid = true;
                } else {
                    System.out.println("Number must be greater than 0. Please re-enter!");
                }
            } //catch if input is not integer
            catch (Exception e) {
                System.out.println("Input must be integer. Please re-enter!");
            }
        }

        return number;
    }

    private static int[] generateIntegerArray(int length) {
        int[] array = new int[length];

        // Loop through each element to generate random value
        for (int i = 0; i < length; i++) {
            array[i] = (int) (Math.random() * (length + 1));
        }

        return array;
    }

    private static void displayArray(int[] randomIntegerArray) {
        System.out.print("The array: [");

        // Loop each element in array to display
        for (int i = 0; i < randomIntegerArray.length; i++) {
            System.out.print(randomIntegerArray[i] + (i != randomIntegerArray.length - 1 ? ", " : ""));
        }

        System.out.println("]");
    }

    private static void displayIndex(int searchNumber, int[] randomIntegerArray) {
        boolean isFound = false;
        int index = -1;

        // Loop each element in array to check
        for (int i = 0; i < randomIntegerArray.length; i++) {
            // Check if each element equals search number
            if (randomIntegerArray[i] == searchNumber) {
                index = i;
                isFound = true;
                break;
            }
        }

        // Check if search number is found
        if (isFound) {
            System.out.println("Found " + searchNumber + " at index: " + index);
        } else {
            System.out.println("Not found " + searchNumber + " in array!");
        }
    }
}
