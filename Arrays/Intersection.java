import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Intersection {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        // System.out.println("Enter the limit of arr1");
        // int n1 = Sc.nextInt();
        // int[] arr1 = new int[n1];
        // System.out.println("enter the limit of arr2");
        // int n2 = Sc.nextInt();
        // int[] arr2 = new int[n2];

        // System.out.println("Enter" + n1 + "elements in array 1");
        // for (int i = 0; i < n1; i++) {
        // System.out.println("enter the element at index : " + i);
        // arr1[i] = Sc.nextInt();

        // }
        // System.out.println("Enter" + n1 + "elements in array 1");
        // for (int i = 0; i < n2; i++) {
        // System.out.println("enter the element at index : " + i);
        // arr2[i] = Sc.nextInt();

        // }
        int arr1[] = { 1, 2, 2, 3, 3, 4, 5, 6 };
        int arr2[] = { 2, 3, 3, 5, 6, 6, 7 };

        System.out.println(Arrays.toString(brute(arr1, arr2)));
        System.out.println(Arrays.toString(optimal(arr1, arr2)));
        Sc.close();
    }

    // Brute force solution
    // the arrays are in sorted manner
    public static int[] brute(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        ArrayList<Integer> ans = new ArrayList<>();
        int[] visited = new int[Math.min(n1, n2)];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (arr1[i] == arr2[j] && visited[j] == 0) {
                    ans.add(arr1[i]);
                    visited[j] = 1;
                    break;

                }
                if (arr2[j] > arr1[i]) {
                    break;
                }
            }
        }
        int n = ans.size();
        int[] newans = new int[n];
        for (int num = 0; num < n; num++) {
            newans[num] = ans.remove(0);
        }
        return newans;
    }

    public static int[] optimal(int[] arr1, int[] arr2) {

        int n1 = arr1.length;

        int i = 0;
        int j = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while (i < n1) {

            if (arr1[i] == arr2[j]) {
                ans.add(arr1[i]);
                i++;
                j++;
            } else {
                i++;
            }
        }

        int n = ans.size();
        int[] newans = new int[n];
        for (int num = 0; num < n; num++) {
            newans[num] = ans.remove(0);
        }
        return newans;
    }

}