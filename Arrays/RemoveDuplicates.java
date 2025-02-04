import java.util.Arrays;
import java.util.Scanner;

// Remove Duplicates from Sorted Array

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        System.out.println("Enter the limit");
        int n = Sc.nextInt();
        int[] arr = new int[n];
        System.out.println("enter numbers in ascending order");
        
        for (int i = 0; i <= n-1; i++) {
            System.out.println("enter the element at index : "+ i);
            arr[i] = Sc.nextInt();
        
        }
        int ans = removeduplicates(arr);
        System.out.println("The number of unique elements :" + ans);
        System.out.println(Arrays.toString(arr));
        Sc.close();
    }

    public static int removeduplicates(int[] arr) {

        int n = arr.length;
        int i = 0;
        int j = i + 1;
        while (j != n) {
            if (arr[i] == arr[j]) {
                j++;
            } 
            else {
                arr[i + 1] = arr[j];
                i++;
                j++;
            }
        }
        i++;
        while(i!= n)
        {
            arr[i] = 0;
            i++;
        }
        return i + 1;

    }

}