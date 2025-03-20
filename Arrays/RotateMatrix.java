import java.util.Arrays;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        System.out.println("Matrix before Transformation");
        for (int[] i : matrix) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println("After transformation");
        // int[][] ans = brute(matrix);
        //
        optimal(matrix);
        for (int[] i : matrix) {
            System.out.println(Arrays.toString(i));
        }

    }

    public static int[][] brute(int[][] matrix) {
        int n = matrix.length;
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][n - 1 - i] = matrix[i][j];
            }
        }
        return ans;
    }

    public static void optimal(int[][] matrix) {
        int n = matrix.length;

        // Transpose
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse
        for (int i = 0; i < n; i++) {
            reverse(matrix[i]);
        }

    }

    public static void reverse(int[] matrix) {
        int s = 0;
        int l = matrix.length - 1;
        while (s < l) {
            int temp = matrix[s];
            matrix[s] = matrix[l];
            matrix[l] = temp;
            s++;
            l--;
        }

    }

}