//Leetcode 560. Subarray Sum Equals K

import java.util.HashMap;

public class CountSubArraysEqualsK {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, -3, 1, 1, 1, 4, 2, -3 };
        int ansbrute = brute(arr, 3);
        int ansoptimal = optimal(arr, 3);
        System.out.println(ansbrute);
        System.out.println(ansoptimal);
    }

    public static int brute(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int c = 0;

        for (int i = 0; i < n; i++) {
            sum = 0;

            for (int j = i; j < n; j++) {
                sum += nums[j];

                if (sum == k) {
                    c++;
                }
            }
        }

        return c;

    }

    public static int optimal(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int presum = 0;
        int c = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            presum += nums[i];

            int remove = presum - k;

            c += map.getOrDefault(remove, 0);

            map.put(presum, map.getOrDefault(presum, 0) + 1);
        }
        return c;

    }
}