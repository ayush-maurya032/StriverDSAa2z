import java.util.Arrays;
import java.util.Scanner;

public class SecondSmallestndLargest {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.println("enter 10 numbers");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Sc.nextInt();
        }
        brute(arr);
        better(arr);
        optimal(arr);
        Sc.close();

    }

    public static void brute(int[] arr) {

        Arrays.sort(arr);
        System.out.println("The second smallest number is " + arr[1]);
        System.out.println("The second largest number is " + arr[arr.length - 2]);

    }

    public static void better(int[] arr) {
        int n = arr.length;
        if (n == 0 || n == 1) {
            System.out.print(-1);
            System.out.print(" ");
            System.out.print(-1);
            System.out.print("\n");
        }
        int small = Integer.MAX_VALUE;
        int second_small = Integer.MAX_VALUE;
        int large = Integer.MIN_VALUE;
        int second_large = Integer.MIN_VALUE;
        int i;
        for (i = 0; i < n; i++) {
            small = Math.min(small, arr[i]);
            large = Math.max(large, arr[i]);
        }
        for (i = 0; i < n; i++) {

            if (arr[i] < second_small && arr[i] != small) {
                second_small = arr[i];
            }

            if (arr[i] > second_large && arr[i] != large) {
                second_large = arr[i];
            }
        }

        System.out.println("Second smallest is " + second_small);
        System.out.println("Second largest is " + second_large);

    }

    public static void optimal(int[] arr) {

        int n = arr.length;
        if (n < 2) {
            System.out.println(-1);
        }

        int small = Integer.MAX_VALUE;
        int second_small = Integer.MAX_VALUE;
        int large = Integer.MIN_VALUE;
        int second_large = Integer.MIN_VALUE;
        int i;

        for (i = 0; i < n; i++) {

            if (arr[i] < small) {
                second_small = small;
                small = arr[i];
            } else if (arr[i] < second_small && arr[i] != small) {
                second_small = arr[i];

            }

            if (arr[i] > large) {
                second_large = large;
                large = arr[i];
            }

            else if (arr[i] > second_large && arr[i] != large) {
                second_large = arr[i];
            }

        }
        System.out.println("Second smallest is " + second_small);
        System.out.println("Second largest is " + second_large);

    }
}
