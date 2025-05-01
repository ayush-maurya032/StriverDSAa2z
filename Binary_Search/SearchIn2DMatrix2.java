public class SearchIn2DMatrix2 {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 4, 7, 11, 15 },
                { 2, 5, 8, 12, 19 },
                { 3, 6, 9, 16, 22 },
                { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 }
        };
        int target = 16;
        System.out.println(matSearchOptimal(matrix, target));
        System.out.println(matSearchBrute(matrix, target));
    }

    public static boolean matSearchOptimal(int matrix[][], int target) {
        // O(n + m)
        int n = matrix.length;
        int m = matrix[0].length;
        int row = 0;
        int col = m - 1;
        while (row < n && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;

    }

    public static boolean matSearchBrute(int matrix[][], int target) {
        // your code here
        int n = matrix.length;
        int m = matrix[0].length;
        int ind = -1;
        for (int i = 0; i < n; i++) {
            ind = binarysearch(matrix[i], target);
            if (ind != -1) {
                return true;
            }
        }
        return false;
    }

    static int binarysearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return -1;
    }
}