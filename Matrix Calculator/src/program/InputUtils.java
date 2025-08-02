package program;

import java.util.Scanner;

class InputUtils {
    static Scanner sc = new Scanner(System.in);

    static int inputChoice(String msg) {
        String input;
        int number;

        while (true) {
            try {
                System.out.print(msg);
                input = sc.nextLine();
                if (input.isEmpty()) {
                    System.out.println("Input can not null. Please enter again!");
                    continue;
                }
                number = Integer.parseInt(input);
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

        while (true) {
            try {
                System.out.print(string);
                input = sc.nextLine();
                if (input.isEmpty()) {
                    System.out.println("Input can not null. Please enter again!");
                    continue;
                }
                number = Integer.parseInt(input);
                if (number <= 0) {
                    System.out.println("Please enter a positive integer!");
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
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = inputMatrixValue("Enter " + name + "[" + (i + 1) + "][" + (j + 1) + "]:");
            }
        }
        return matrix;
    }

    static int inputMatrixValue(String msg) {
        String input;
        int number;

        while (true) {
            try {
                System.out.print(msg);
                input = sc.nextLine();
                if (input.isEmpty()) {
                    System.out.println("Input can not null. Please enter again!");
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
