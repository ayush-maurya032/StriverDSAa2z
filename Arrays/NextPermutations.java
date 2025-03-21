//Leetcode 31.

import java.util.Arrays;

public class NextPermutations {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;
        // Finding the dip index i.e finding longest prefix match
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Finding slight greater among remaining array which is slight greater than the
        // dip index
        for (int i = n - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                break;

            }
        }

        // Finally reversing the remaining array
        reverse(nums, index + 1, n - 1);
    }

    static void reverse(int[] arr, int s, int l) {

        while (s <= l) {
            int temp = arr[s];
            arr[s] = arr[l];
            arr[l] = temp;
            s++;
            l--;
        }
    }
}