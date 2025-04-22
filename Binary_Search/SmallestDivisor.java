public class SmallestDivisor{
    public static void main(String[] args) {
        int[] nums = {1,2,5,9};
        
        System.out.println(smallestDivisorBrute(nums, 6));
        System.out.println(smallestDivisorOptimal(nums, 6));
    }
    public static int smallestDivisorBrute(int[] nums, int threshold) {
        int n = nums.length;
        int max = nums[0];
        int min = nums[0];
        for(int i = 0; i < n; i++){
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }

        for(int i = 1; i <= max; i++){
            int sum = divsum(nums, i);
            if(sum <= threshold){
                return i;
            }
        }
        return min;
    }


    public static int smallestDivisorOptimal(int[] nums, int threshold) {
        int n = nums.length;
        int max = nums[0];
        int min = nums[0];
        int ans = max;
        for(int i = 0; i < n; i++){
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }

        
        int low = 1;
        int high = max;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int sum = divsum(nums,mid);
            if(sum <= threshold){
                ans = mid;
                high = mid - 1;

            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
   static  int divsum(int[] arr, int div){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
           sum += (arr[i] + div - 1) / div;

        }
        return sum;
    }
}