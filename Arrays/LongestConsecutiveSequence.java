
//Leetcode 128. Longest Consecutive Sequence
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = { 102, 4, 100, 1, 101, 3, 2, 1, 1 };
        System.out.println(brute(arr));
        System.out.println(better(arr));
        System.out.println(optimal(arr));

    }

    public static boolean ls(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return true;
            }
        }
        return false;
    }

    public static int brute(int[] arr) {
        int n = arr.length;

        int longest = 1;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int x = arr[i];
            cnt = 1;
            while (ls(arr, x + 1) == true) {
                x = x + 1;
                cnt = cnt + 1;

            }
            longest = Math.max(longest, cnt);
        }

        return longest;
    }

    public static int better(int[] arr) {
        int longest = 1;
        Arrays.sort(arr);
        int cnt = 0;
        int lastsmaller = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - 1 == lastsmaller) {
                cnt = cnt + 1;
                lastsmaller = arr[i];
            } else if (arr[i] != lastsmaller) {
                cnt = 1;
                lastsmaller = arr[i];

            }

            longest = Math.max(longest, cnt);
        }

        return longest;
    }

    public static int optimal(int[] arr) {
        int longest = 1;
        int cnt = 0;
        int n = arr.length;
        if (n == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        for (int it : set) {
            if (!set.contains(it - 1)) {
                cnt = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    cnt = cnt + 1;

                }
            }
            longest = Math.max(longest, cnt);
        }

        return longest;
    }

}