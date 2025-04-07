
public class FloorInSortedArray {
 public static void main(String[] args) {
    int arr[] = {1, 2, 8, 10, 10, 12, 19}; int x = 5;
    System.out.println(findFloor(arr, x));
 }

    public static int findFloor(int[] arr, int x) {
        // int floorIndex = -1;
        // for (int i = 0; i < arr.length; i++) {
        //     if (arr[i] <= x) {
        //         floorIndex = i;
        //     } else {
        //         break; // Since array is sorted, no need to check further
        //     }
        // }
        // return floorIndex;
        
        //optimal approach
                int low = 0, high = arr.length - 1;
        int res = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] <= x) {
                res = mid; // possible floor found
                low = mid + 1; // search right
            } else {
                high = mid - 1; // search left
            }
        }

        return res;


    }
}
