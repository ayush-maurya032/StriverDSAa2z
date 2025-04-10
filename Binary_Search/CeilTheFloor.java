//GFG
/*
 * https://www.geeksforgeeks.org/problems/ceil-the-floor2802/1
 */


import java.util.Arrays;

public class CeilTheFloor{
    public static void main(String[] args) {
        int[] arr = {5, 6, 8, 9, 6, 5, 5, 6}; 
        int x = 7;
        System.out.println(Arrays.toString(getFloorAndCeil(x, arr)));
        System.out.println(Arrays.toString(findFloorAndCeil(arr, x)));
        
    }
    public static int[] getFloorAndCeil(int x, int[] arr) {
        
        int n = arr.length;
        int floor = -1;
        int ceil = -1;
         for (int i = 0; i < n; i++) {
            if (arr[i] <= x) {
                if (floor == -1 || arr[i] > floor) {
                    floor = arr[i];
                }
            }

            if (arr[i] >= x) {
                if (ceil == -1 || arr[i] < ceil) {
                    ceil = arr[i];
                }
            }
        }

        return new int[]{floor, ceil};
        
      
    }



    public static int[] findFloorAndCeil(int[] arr, int x) {
        Arrays.sort(arr); // Step 1: Sort the array

        int floor = -1;
        int ceil = -1;
        int low = 0, high = arr.length - 1;

        // Step 2: Binary Search for Floor and Ceil
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                floor = arr[mid];
                ceil = arr[mid];
                break;
            } else if (arr[mid] < x) {
                floor = arr[mid];  // possible floor
                low = mid + 1;
            } else {
                ceil = arr[mid];   // possible ceil
                high = mid - 1;
            }
        }

        return new int[]{floor, ceil};
    }
}