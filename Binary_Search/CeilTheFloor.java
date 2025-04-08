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
        
    }
    public static int[] getFloorAndCeil(int x, int[] arr) {
        
        int n = arr.length;
        int floor = -1;
        int ceil = -1;
         for (int i = 0; i < arr.length; i++) {
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
}