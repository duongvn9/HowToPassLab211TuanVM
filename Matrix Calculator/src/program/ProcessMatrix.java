package program;

class ProcessMatrix {

    static void processAddOrSubtract(String operator) {
        if (operator.equals("+")) {
            System.out.println("-------- Addition --------");
        } else {
            System.out.println("-------- Subtraction --------");
        }

        int row1 = InputUtils.inputRowCol("Enter Row Matrix 1: ");
        int col1 = InputUtils.inputRowCol("Enter Column Matrix 1: ");
        int[][] matrix1 = InputUtils.inputMatrix(row1, col1, "Matrix1");

        int row2, col2;

        while (true) {
            row2 = InputUtils.inputRowCol("Enter Row Matrix 2: ");
            col2 = InputUtils.inputRowCol("Enter Column Matrix 2: ");
            if (row2 != row1 || col2 != col1) {
                System.out.println("For " + operator + ", both matrices must same dimension");
            } else {
                break;
            }
        }

        int[][] matrix2 = InputUtils.inputMatrix(row2, col2, "Matrix2");
        int[][] result;

        if (operator.equals("+")) {
            result = MatrixCalculator.additionMatrix(matrix1, matrix2);
        } else {
            result = MatrixCalculator.subtractionMatrix(matrix1, matrix2);
        }

        DisplayUtils.displayResult(matrix1, operator, matrix2, result);
    }

    static void processMultiplication() {
        System.out.println("-------- Multiplication --------");
        int row1 = InputUtils.inputRowCol("Enter Row Matrix 1: ");
        int col1 = InputUtils.inputRowCol("Enter Column Matrix 1: ");
        int[][] matrix1 = InputUtils.inputMatrix(row1, col1, "Matrix1");

        int row2;
        while (true) {
            row2 = InputUtils.inputRowCol("Enter Row Matrix 2: ");
            if (row2 != col1) {
                System.out.println("For multiplication, number of row matrix 2 must equal number of column matrix 1");
                continue;
            } else {
                break;
            }
        }

        int col2 = InputUtils.inputRowCol("Enter Column Matrix 2: ");
        int[][] matrix2 = InputUtils.inputMatrix(row2, col2, "Matrix2");
        int[][] result = MatrixCalculator.multiplicationMatrix(matrix1, matrix2);
        DisplayUtils.displayResult(matrix1, "*", matrix2, result);
    }
}
