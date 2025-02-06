import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);

        System.out.println("Enter the limit");
        int n = Sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the numbers one by one");
        for (int i = 0; i < n; i++) {
             arr[i] = Sc.nextInt();
        }
        System.out.println("Enter the number to be searched");
        int k = Sc.nextInt();
        System.out.println(searchInSorted(arr, k));
        Sc.close();
    }

    public static boolean searchInSorted(int arr[], int k) {
            
        for(int i =0; i < arr.length; i++){
            if(arr[i] == k){

                return true;
            }
        }
        return false;
    }






}