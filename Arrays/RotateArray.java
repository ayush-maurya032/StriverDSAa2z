import java.util.Arrays;
import java.util.Scanner;
//rotating right

//Right Rotation: Reverse → Reverse first k → Reverse rest
//Left Rotation (Your Way): Reverse → Reverse first n-k → Reverse last k
public class RotateArray {
    public static void main(String[] args) {
         Scanner Sc = new Scanner(System.in);
        System.out.println("Enter the limit");
        int n = Sc.nextInt();
        int[] arr = new int[n];
        System.out.println("enter numbers ");
        System.out.println("Enter the frequency of rotation");
        int k = Sc.nextInt();
        
        for (int i = 0; i <= n-1; i++) {
            System.out.println("enter the element at index : "+ i);
            arr[i] = Sc.nextInt();
        
        }
        rotate(arr,k);
        System.out.println(Arrays.toString(arr));
    }


    public static void  rotate(int[] nums, int k) {
        int n = nums.length;
         k = k % n; // In case k > n
 
         // Step 1: Reverse the whole array
         reverse(nums, 0, n - 1);
 
         // Step 2: Reverse first k elements
         reverse(nums, 0, k - 1);
 
         // Step 3: Reverse the rest
         reverse(nums, k, n - 1);
     }
 
 
     private static void reverse(int[] nums, int start, int end) {
         while (start < end) {
             int temp = nums[start];
             nums[start] = nums[end];
             nums[end] = temp;
             start++;
             end--;
         }
     }
 

}
