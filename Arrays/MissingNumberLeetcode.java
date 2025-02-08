public class MissingNumberLeetcode{
    public static void main(String[] args) {
        int nums[] = {3, 0, 1}; // Expected output: 2 (since 2 is missing)

        int ans1 = missingNumberBrute(nums);
        int ans2 = missingNumberBetter(nums);
        int ans3 = missingNumberOptimal1(nums);
        int ans4 = missingNumberOptimal2(nums);

        System.out.println("The missing number by Brute Force: " + ans1);
        System.out.println("The missing number by Hashing: " + ans2);
        System.out.println("The missing number by Sum Formula: " + ans3);
        System.out.println("The missing number by XOR: " + ans4);
    }

    // Brute Force Approach: O(n^2) time, O(1) space
    public static int missingNumberBrute(int[] nums) {
        int N = nums.length; // The range is from [0, N]
        for (int i = 0; i <= N; i++) { // Search in range [0, N]
            boolean found = false;
            for (int num : nums) {
                if (num == i) {
                    found = true;
                    break;
                }
            }
            if (!found) return i;
        }
        return -1;
    }

    // Hashing Approach: O(n) time, O(n) space
    public static int missingNumberBetter(int[] nums) {
        int N = nums.length;
        boolean[] hash = new boolean[N + 1]; // Create a boolean array to track presence

        for (int num : nums) hash[num] = true;

        for (int i = 0; i <= N; i++) {
            if (!hash[i]) return i;
        }
        return -1;
    }

    // Sum Formula Approach: O(n) time, O(1) space
    public static int missingNumberOptimal1(int[] nums) {
        int N = nums.length;
        int expectedSum = (N * (N + 1)) / 2; // Sum of numbers from 0 to N
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }

    // XOR Approach: O(n) time, O(1) space
    public static int missingNumberOptimal2(int[] nums) {
        int xor1 = 0, xor2 = 0;
        int N = nums.length;

        for (int num : nums) xor2 ^= num;  // XOR of array elements
        for (int i = 0; i <= N; i++) xor1 ^= i; // XOR of numbers from 0 to N

        return xor1 ^ xor2; // Missing number
    }
}