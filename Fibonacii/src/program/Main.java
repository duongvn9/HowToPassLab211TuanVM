package program;

/*
 * 
 * @author duongvnhe191516
 */
public class Main {

    public static void main(String[] args) {
        // Step 1: Use recursion method to find 45 sequence Fibonacci
        int[] fibonacciArray = recursionToFindFibonacci(45);
        // Step 2: Display 45 Fibonacci sequence to screen
        displayFibonacciArray(fibonacciArray);
    }

    private static int[] recursionToFindFibonacci(int length) {
        int[] array = new int[length];

        // Assign two first number
        array[0] = 0;
        array[1] = 1;

        // Call recursion method add next fibonacci number to array
        addFibonacciNumber(array, 2);

        return array;
    }

    private static void addFibonacciNumber(int[] array, int index) {
        // Check if index = 0 or 1
        if (index == 0 || index == 1)
            array[index] = index;
        // other number
        else
            array[index] = array[index - 1] + array[index - 2];

        // increase index
        index++;

        // check if index = array length to return
        if (index == array.length) {
            return;
        }

        addFibonacciNumber(array, index);
    }

    private static void displayFibonacciArray(int[] fibonacciArray) {
        System.out.print("The " + fibonacciArray.length + " sequence fibonacci: ");

        // loop iterate element in array to display
        for (int i = 0; i < fibonacciArray.length; i++) {
            System.out.print(fibonacciArray[i] + ((i < (fibonacciArray.length - 1)) ? ", " : ""));
        }
        System.out.println();
        int number = 1;
        // check is 45 number
        for (int i = 0; i < fibonacciArray.length; i++) {
            System.out.print("Number " + number + ": " + fibonacciArray[i] + "\n");
            number++;
        }
    }
}