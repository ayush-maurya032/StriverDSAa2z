import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4, 5, 6 },
                { 20, 21, 22, 23, 24, 7 },
                { 19, 32, 33, 34, 25, 8 },
                { 18, 31, 36, 35, 26, 9 },
                { 17, 30, 29, 28, 27, 10 },
                { 16, 15, 14, 13, 12, 11 }
        };

        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();

        int n = matrix.length;
        int m = matrix[0].length;

        int left = 0;
        int right = m - 1;
        int top = 0;
        int bottom = n - 1;

        while (left <= right && top <= bottom) {

            // right traverse
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);

            }
            top++;

            // bottom traverse
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;

            // left traverse

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // top traverse
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }

        }

        return list;
    }
}