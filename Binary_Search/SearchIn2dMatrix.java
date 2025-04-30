public class SearchIn2dMatrix {
    public static void main(String[] args) {
        int[][] mat = { { 3, 4, 6, 9 }, { 10, 12, 13, 15 }, { 17, 18, 19, 20 } };
        int target = 12;
        System.out.println(searchMatrixOptimal(mat, target));
        System.out.println(searchMatrixBrute(mat, target)); // complexity --> n + logm
    }

    public static boolean searchMatrixBrute(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] <= target && matrix[i][n - 1] >= target) {
                return binarysearch(matrix[i], target);
            }
        }
        return false;
    }

    static boolean binarysearch(int[] arr, int target) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target)
                return true;
            else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public static boolean searchMatrixOptimal(int[][] matrix, int target) {
        // complexity = log(n*m)
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = n * m - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = mid / n;
            int col = mid % n;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;

    }
}