public class KthMissingNumber{
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        System.out.println(brute(arr, 5));
        System.out.println(optimal(arr, 5));
    }
    public static int brute(int[] arr, int k){
        int n  = arr.length;
        for(int i = 0; i < n; i++){
            if(arr[i] <= k){
                k++;
            }
            else{
                break;
            }
        }
        return k;
    }

    public static int optimal(int[] arr, int k){
        int n = arr.length;
        int low = 0;
        int high = n-1;
        while(low <= high)
        {
            int mid = (low + high) / 2;
            int missing = arr[mid] - (mid + 1);
            if(missing < k){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return low + k; // most important logic refer notes
    }
    }
