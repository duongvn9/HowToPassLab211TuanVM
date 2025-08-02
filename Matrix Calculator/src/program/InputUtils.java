package program;

import java.util.Scanner;

/**
 * @author pc
 */
class InputUtils {

    static Scanner sc = new Scanner(System.in);

    static int inputChoice(String msg) {
        String input;
        int number;
        // loop infinity
        while (true) {
            try {
                System.out.print(msg);
                input = sc.nextLine();
                // check if input is empty
                if (input.isEmpty()) {
                    System.out.println("Input can not null. Please enter again!");
                    // loop until get string input
                    continue;
                }
                number = Integer.parseInt(input);
                // check if input is not positive integer
                if (number < 1 || number > 4) {
                    System.out.println("Please enter an integer in range [1,4]");
                } else {
                    return number;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter an integer in range [1,4]");
            }
        }
    }

    static int inputRowCol(String string) {
        String input;
        int number;
        // loop infinity
        while (true) {
            try {
                System.out.print(string);
                input = sc.nextLine();
                // check if input is empty
                if (input.isEmpty()) {
                    System.out.println("Input can not null. Please enter again!");
                    // loop until get string input
                    continue;
                }
                number = Integer.parseInt(input);
                // check if input is not positive integer
                if (number <= 0) {
                    System.out.println("Please enter a positive integer!");
                    // loop until get valid number
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a positive integer");
            }
        }
        return number;
    }

    static int[][] inputMatrix(int row, int col, String name) {
        int[][] matrix = new int[row][col];
        // loop iterate element in row
        for (int i = 0; i < row; i++) {
            // loop iterate element in col
            for (int j = 0; j < col; j++) {
                matrix[i][j] = inputMatrixValue("Enter " + name + "[" + (i + 1) + "][" + (j + 1) + "]:");
            }
        }
        return matrix;
    }

    static int inputMatrixValue(String msg) {
        String input;
        int number;
        // loop infinity
        while (true) {
            try {
                System.out.print(msg);
                input = sc.nextLine();
                // check if input is empty
                if (input.isEmpty()) {
                    System.out.println("Input can not null. Please enter again!");
                    // loop until get string input
                    continue;
                }
                number = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Value of matrix is digit");
            }
        }
        return number;
    }
}
