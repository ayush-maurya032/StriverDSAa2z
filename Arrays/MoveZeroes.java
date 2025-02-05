import java.util.Arrays;
import java.util.Scanner;

public class MoveZeroes {
   public static void main(String[] args) {
      Scanner Sc = new Scanner(System.in);
      int[] arr = new int[3];
      System.out.println("enter numbers");
      for (int i = 0; i < arr.length; i++) {
         arr[i] = Sc.nextInt();
      }

      moveZeroes(arr);
      System.out.println(Arrays.toString(arr));
      Sc.close();
   }

   public static void moveZeroes(int[] nums) {
      int i = 0;
      int n = nums.length;
      while (i != n) {

         if (nums[i] == 0) {
            shift(nums, i, n - 1);
            n--;
         } else {
            i++;
         }

      }

   }

   public static void shift(int[] arr, int start, int end) {
      int temp = arr[start];
      while (start != end) {
         arr[start] = arr[start + 1];
         start++;
      }
      arr[end] = temp;

   }

   public static void moveZeroesImproved(int[] nums) {
      int n = nums.length;
      int j = -1;
      // place the pointer j:
      for (int i = 0; i < n; i++) {
         if (nums[i] == 0) {
            j = i;
            break;
         }
      }
      // no non-zero elements:
      if (j == -1)
         return;

      // Move the pointers i and j
      // and swap accordingly:
      for (int i = j + 1; i < n; i++) {
         if (nums[i] != 0) {
            // swap a[i] & a[j]:
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            j++;
         }
      }

   }

}
