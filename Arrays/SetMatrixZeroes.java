
//73. Set Matrix Zeroes Leetcode

import java.util.Arrays;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 1, 1, 1 },
                { 1, 0, 1, 1 },
                { 1, 1, 0, 1 },
                { 0, 1, 1, 1 }
        };

        // brute(matrix);

        // System.out.println("The Final matrix is:");
        // for (int[] row : matrix) {
        // System.out.println(Arrays.toString(row));
        // }

        // better(matrix);

        // System.out.println("The Final matrix is:");
        // for (int[] row : matrix) {
        // System.out.println(Arrays.toString(row));
        // }

        optimal(matrix);

        System.out.println("The Final matrix is:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void MakeCol(int[][] matrix, int j) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][j] != 0) {
                matrix[i][j] = -1;
            }
        }
    }

    public static void MakeRow(int[][] matrix, int i) {
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[i][j] != 0) {
                matrix[i][j] = -1;
            }
        }
    }

    public static void brute(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // Mark rows and columns
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    MakeRow(matrix, i);
                    MakeCol(matrix, j);
                }
            }
        }

        // Convert -1 to 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void better(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        int col[] = new int[m];
        int row[] = new int[n];
        // marking the rows and colums needed to be marked all zeroes
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void optimal(int[][] matrix) {
        // col[o]----> row[n] --- matrix[0][...]
        // row[0] ---> col[n] ---- matrix[...][0]
        int col0 = 1;
        int n = matrix.length;
        int m = matrix[0].length;
        // marking
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    // mark the ith row
                    matrix[i][0] = 0;
                    // mark the jth col
                    if (j != 0) {
                        matrix[0][j] = 0;
                    } else {
                        col0 = 0;
                    }

                }

            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] != 0) {
                    // check
                    if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        // checking the common 0,0 element
        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }

    }

}
