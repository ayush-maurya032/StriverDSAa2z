import java.util.Scanner;

public class MaximumConsecutiveOnes {

    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        System.out.println("Enter the limit");
        int n = Sc.nextInt();

        int[] arr = new int[n];
        System.out.println("enter numbers");
        for (int i = 0; i < n; i++) {
            arr[i] = Sc.nextInt();
        }

        int ans  = findMaxConsecutiveOnes(arr);
        System.out.println(ans);

        Sc.close();
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                maxCount = Math.max(maxCount, count);
                count = 0;
            } else {
                count++;
            }

        }
        return Math.max(maxCount, count);
    }
}
