package cracking_coding_interview.chapter_1.arrays_strings;

/**
 * Created by mayank.gupta on 29/04/17.
 *
 * 1.7 - if any element in MxN matrix is zero, we need to make every element in the row and column as zero
 */
public class MatrixUpdateZero {

    public void update(int[][] matrix) {

        int rows = matrix.length;
        int columns = matrix[0].length;

        boolean[][] zerosFound = new boolean[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 0)
                    zerosFound[i][j] = true;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (zerosFound[i][j]) {
                    updateZero(matrix, i, j);
                }
            }
        }
        printMatrix(matrix);

    }

    private void updateZero(int[][] matrix, int row, int column) {

        for(int i=0; i < matrix.length; i++) {
            matrix[i][column] = 0;
        }

        for(int i=0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }

    private void printMatrix(int[][] matrix) {
        System.out.println();
        System.out.println("Printing ......");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[3][3];

        matrix[0][0] = 1;
        matrix[0][1] = 0;
        matrix[0][2] = 3;
        matrix[1][0] = 10;
        matrix[1][1] = 20;
        matrix[1][2] = 0;
        matrix[2][0] = 40;
        matrix[2][1] = 50;
        matrix[2][2] = 60;

        MatrixUpdateZero m = new MatrixUpdateZero();

        m.printMatrix(matrix);

        m.update(matrix);
    }

}
