package program;

class DisplayUtils {

    static void displayMenu() {
        System.out.println("====== CaCulator program ======");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
    }

    static void displayResult(int[][] matrix1, String operator, int[][] matrix2, int[][] result) {
        System.out.println("------- Result --------");
        displayMatrix(matrix1);
        System.out.println(operator);
        displayMatrix(matrix2);
        System.out.println("=");
        displayMatrix(result);
    }

    static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int number : row) {
                System.out.print("[" + number + "]");
            }
            System.out.println();
        }
    }
}
