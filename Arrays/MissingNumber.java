public class MissingNumber {


    //Problem Statement: Given an integer N and an array of size N-1 containing N-1 numbers between 1 to N. Find the number(between 1 to N), that is not present in the given array.
    public static void main(String[] args) {
        int a[] = {1, 2, 4, 5}; // The missing number should be 3

        int ans1 = missingNumberBrute(a);
        int ans2 = missingNumberBetter(a);
        int ans3 = missingNumberOptimal1(a);
        int ans4 = missingNumberOptimal2(a);

        System.out.println("The missing number by Brute Force: " + ans1);
        System.out.println("The missing number by Hashing: " + ans2);
        System.out.println("The missing number by Sum Formula: " + ans3);
        System.out.println("The missing number by XOR: " + ans4);
    }

    // Brute Force: O(n^2) time, O(1) space
    public static int missingNumberBrute(int[] nums) {
        int N = nums.length;
        // Outer loop that runs from 1 to N:
        for (int i = 1; i <= N; i++) {

            // flag variable to check
            //if an element exists
            int flag = 0;

            //Search the element using linear search:
            for (int j = 0; j < N - 1; j++) {
                if (nums[j] == i) {

                    // i is present in the array:
                    flag = 1;
                    break;
                }
            }

            // check if the element is missing
            //i.e flag == 0:

            if (flag == 0) return i;
        }

        // The following line will never execute.
        // It is just to avoid warnings.
        return -1;
    }

    // Better Approach using Hashing: O(n) time, O(n) space
    public static int missingNumberBetter(int[] nums) {
        int N = nums.length;
        int hash[] = new int[N + 1]; //hash array

        // storing the frequencies:
        for (int i = 0; i < N - 1; i++)
            hash[nums[i]]++;

        //checking the freqencies for numbers 1 to N:
        for (int i = 1; i <= N; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }

        // The following line will never execute.
        // It is just to avoid warnings.
        return -1;
    }

    // Sum Formula Approach: O(n) time, O(1) space
    public static int missingNumberOptimal1(int[] nums) {
        int N = nums.length;
        int sum = (N * (N + 1)) / 2;

        //Summation of all array elements:
        int s2 = 0;
        for (int i = 0; i < N - 1; i++) {
            s2 += nums[i];
        }

        int missingNum = sum - s2;
        return missingNum;
    }

    // XOR Approach: O(n) time, O(1) space
    public static int missingNumberOptimal2(int[] nums) {
        int xor1 = 0, xor2 = 0;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            xor2 = xor2 ^ nums[i]; // XOR of array elements
            xor1 = xor1 ^ (i + 1); //XOR up to [1...N-1]
        }
        xor1 = xor1 ^ n; //XOR up to [1...N]

        return (xor1 ^ xor2); // the missing number
    }
}
