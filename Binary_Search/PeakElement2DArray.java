public class PeakElement2DArray {
    public static void main(String[] args) {
        int[][] mat = {
                { 10, 8, 10, 10 },
                { 14, 13, 12, 11 },
                { 15, 9, 11, 21 },
                { 16, 17, 19, 20 }
        };
        System.out.println(peakelementOptimal(mat));
    }

    public static int[] peakelementOptimal(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = fun(mat, m, n, mid);
            int left = (mid - 1 >= 0) ? mat[row][mid - 1] : -1;
            int right = (mid + 1 < n) ? mat[row][mid + 1] : -1;
            if (mat[row][mid] > left && mat[row][mid] > right) {
                return new int[] { row, mid };
            } else if (right > mat[row][mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return new int[] { -1, -1 };
    }

    public static int fun(int[][] mat, int m, int n, int col) {
        int maxValue = -1;
        int index = -1;
        for (int i = 0; i < m; i++) {
            if (mat[i][col] > maxValue) {
                maxValue = mat[i][col];
                index = i;
            }
        }
        return index;
    }
}