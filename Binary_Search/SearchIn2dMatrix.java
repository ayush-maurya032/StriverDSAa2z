public class SearchIn2dMatrix {
    public static void main(String[] args) {
        int[][] mat = { { 3, 4, 6, 9 }, { 10, 12, 13, 15 }, { 17, 18, 19, 20 } };
        int target = 12;
        System.out.println(searchMatrixOptimal(mat, target));
    }

    public static boolean searchMatrixBrute(int[][] matrix, int target) {

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