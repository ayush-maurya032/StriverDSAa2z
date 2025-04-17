import java.util.ArrayList;

public class PeakElement{
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 5, 1};
        System.out.println(findPeakElement(arr));
        System.out.println(findPeakElementOptimal(arr));
    }
    public static int findPeakElement(int[] arr) {
        int n = arr.length; // Size of array.
    
        for (int i = 0; i < n; i++) {
            // Checking for the peak:
            if ((i == 0 || arr[i - 1] < arr[i]) && 
                (i == n - 1 || arr[i] > arr[i + 1])) { // Fix: compare arr[i] > arr[i+1] instead of arr[i] > arr[i-1]
                return i;
            }
        }
        // Dummy return statement
        return -1;
    }

    public static int findPeakElementOptimal(int[] arr) {
        int n = arr.length;
       if(n == 1) return 0;
       if(arr[0] > arr[1]) return 0;
       if(arr[n-1] > arr[n - 2]) return n-1;
       
       int low = 1; int high = n - 2;
       while(low <= high){
           int mid = low + (high - low) / 2;
           if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]){
               return mid;
           }
           
           if(arr[mid] > arr[mid - 1]){
               low = mid + 1;
           }
           else{
               high = mid - 1;
           }
       }
       return -1;
   }
    

}