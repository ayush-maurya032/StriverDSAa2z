import java.util.HashMap;
import java.util.Scanner;

public class LongestSubArray {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        System.out.println("Enter the sum value");
        int k = Sc.nextInt();

        // nt[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
        int[] arr = { 2,7,11,15 };

        // ystem.out.println(longestsubarraybrutest(arr, k));
        // stem.out.println(longestsubarraybetter1(arr, k));
        System.out.println(longestsubarrayslidingwindow(arr, k));
    }

    // O(n^3)
    public static int longestsubarraybrutest(int[] arr, int k) {

        int n = arr.length;
        int len = 0;
        // loop for setting starting index...
        for (int i = 0; i < n; i++) {
            // loop for ending index
            for (int j = i; j < n; j++) {
                // sum
                long s = 0;
                for (int m = i; m <= j; m++) {
                    s = s + arr[m];
                }
                if (s == k) {
                    len = Math.max(len, j - i + 1);
                }

            }

        }
        return len;
    }

    public static int longestsubarraybetter1(int[] arr, int k) {

        int n = arr.length;
        int len = 0;
        // loop for setting starting index...
        for (int i = 0; i < n; i++) {
            long s = 0;
            for (int j = i; j < n; j++) {
                // sum
                s += arr[j];

                if (s == k) {
                    len = Math.max(len, j - i + 1);
                }

            }

        }
        return len;

    }

    // kadane
    public static int longestsubarrayoptimal(int[] arr, int k) {
        int n = arr.length;
        int sum = 0;
        int start = 0;
        int ansEnd = 0;
        int ansStart = 0;
        for (int i = 0; i < n; i++) {
            if (sum == 0) {
                start = i;
            }
            sum += arr[i];

            if (sum >= k) {
                ansStart = start;
                ansEnd = i;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return (ansEnd - ansStart + 1);
    }

    public static int longestsubarrayusinghashmap(int[] arr, int k) {

        int n = arr.length;
        HashMap<Integer, Integer> preSumMap = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            int rem = sum - k;

            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }

        }
        return maxLen;
    }

    // two pointer approach for negatives too
    public static int longestsubarrayslidingwindow(int[] arr, int k) {

        int n = arr.length;
        int left = 0;
        int right = 0;
        int maxLen = 0;
        long sum = arr[0];
        while (right < n) {
           

            while (left <= right && sum > k) {
                sum -= arr[left];
                left++;
            }

            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }


            right++;
            if (right < n) {
                sum += arr[right];
            }
        }
        return maxLen;

    }

}
