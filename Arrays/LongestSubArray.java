import java.util.Scanner;

public class LongestSubArray {
    public static void main(String[] args) {
 Scanner Sc = new Scanner(System.in);
        System.out.println("Enter the limit");
        int k = Sc.nextInt();

        int[] arr = new int[6];
        System.out.println("enter numbers");
        for (int i = 0; i < 6; i++) {
            arr[i] = Sc.nextInt();
        }

        System.out.println(longestsubarraybrutest(arr, k));
        System.out.println(longestsubarraybetter1(arr, k));
    }
    //O(n^3)
    public static int longestsubarraybrutest(int[] arr, int k) {

        int n = arr.length;
        int len = 0;
        // loop for setting starting index...
        for (int i = 0; i < n; i++) {
            // loop for ending index
            for (int j = i; j < n; j++) {
                 //sum
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









    public static int longestsubarraybetter1(int[] arr, int k ){

        int n = arr.length;
        int len = 0;
        // loop for setting starting index...
        for (int i = 0; i < n; i++) {
            long s = 0;
            for (int j = i; j < n; j++) {
                 //sum
                s += arr[j];
               
                
                if (s == k) {
                    len = Math.max(len, j - i + 1);
                }

            }

        }
        return len;

    }

}
