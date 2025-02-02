import java.util.Arrays;
import java.util.Scanner;

public class SecondSmallestndLargest {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.println("enter 10 numbers");
        for(int i =0; i< arr.length;i++){
            arr[i] = Sc.nextInt();
        }
        brute(arr);
    }

    public static void brute(int[] arr){

      Arrays.sort(arr);
      System.out.println("The second smallest number is " + arr[1] );
      System.out.println("The second largest number is " + arr[arr.length - 2]);




    }

    public static void better(int[] arr){}

    public static void optimal(int[] arr){}
}
