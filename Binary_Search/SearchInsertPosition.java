public class SearchInsertPosition{
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,7};
        System.out.println(lowerBound(arr, 6));
    }
    public static int lowerBound(int[] arr, int target){
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int ans = n;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] >= target){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }

        }
        return ans;
    }
}