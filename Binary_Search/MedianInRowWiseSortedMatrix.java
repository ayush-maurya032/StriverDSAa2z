public class MedianInRowWiseSortedMatrix {
    public static void main(String[] args) {
        int[][] mat = {
                { 1, 3, 5 },
                { 2, 6, 9 },
                { 3, 6, 9 }
        };
        System.out.println(median(mat));
    }

    static int upperBound(int[] arr, int x, int n) {
        int low = 0;
        int high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    static int countSmallestEqual(int[][] mat, int n, int m, int x) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += upperBound(mat[i], x, m);
        }
        return cnt;
    }

    static int median(int mat[][]) {
        // code here
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0; i < n; i++) {
            low = Math.min(low, mat[i][0]);
            high = Math.max(high, mat[i][m - 1]);
        }

        int req = (n * m) / 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int smallestEqual = countSmallestEqual(mat, n, m, mid);

            if (smallestEqual <= req)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return low;

    }
}