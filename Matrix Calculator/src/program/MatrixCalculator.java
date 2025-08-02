package program;

/**
 * @author pc
 */
class MatrixCalculator {

    public static int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        int row = matrix1.length;
        int col = matrix1[0].length;
        int[][] result = new int[row][col];

        // loop iterate element in row of matrix 1
        for (int i = 0; i < row; i++) {
            // loop iterate element in col of matrix 1
            for (int j = 0; j < col; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    public static int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        int row = matrix1.length;
        int col = matrix1[0].length;
        int[][] result = new int[row][col];

        // loop iterate element in row of matrix 1
        for (int i = 0; i < row; i++) {
            // loop iterate element in col of matrix 1
            for (int j = 0; j < col; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    public static int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int col2 = matrix2[0].length;
        int[][] result = new int[row1][col2];

        // loop iterate element in row matrix 1
        for (int i = 0; i < row1; i++) {
            // loop iterate element in col matrix 2
            for (int j = 0; j < col2; j++) {
                // loop iterate element in col matrix 1
                for (int k = 0; k < col1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }
}