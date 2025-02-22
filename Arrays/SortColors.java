//LeetCode
// 75. Sort Colors
// Solved
// Medium
// Topics
// Companies
// Hint
// Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

//You must solve this problem without using the library's sort function.

import java.util.Arrays;
import java.util.Scanner;

public class SortColors {
    public static void main(String[] args) {
         Scanner Sc = new Scanner(System.in);
        System.out.println("Enter the limit");
        int n = Sc.nextInt();

        int[] arr = new int[n];
        System.out.println("enter numbers");
        for (int i = 0; i < n; i++) {
            arr[i] = Sc.nextInt();
        }

        sortColorsbetter(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void sortColorsbetter(int[] nums) {
        int n = nums.length;
        int c0 = 0;
        int c1 = 0;
        int c2 = 0;
        for(int i = 0; i < n; i++){

            if(nums[i] == 0){
                c0++;
            }
            else if (nums[i] == 1){
                c1++;
            }
            else
            {
                c2++;
            }
        }

        for(int i =0; i < c0; i++){
            nums[i] = 0;
        }
        for(int i = c0; i < c0+c1; i++){
            nums[i] = 1;
        }
        for(int i = c0+c1; i < n; i++){
            nums[i] = 2;
        }





    }
}

