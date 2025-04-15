public class MinInRotSortedArray{
    public static void main(String[] args) {
        int[] arr = { 4,5,6,7,0,1,2};
         System.out.println(findMin(arr));
        
    }
    public static int findMin(int[] nums) {
        int n = nums.length;
        int low = 0; 
        int high = n - 1;
        int ans = Integer.MAX_VALUE;
        while(low <= high){   
            int mid = low + (high - low)/2;
            if(nums[low] <= nums[mid]){   //if left is sorted then fin min and eleminate
                ans = Math.min(ans , nums[low]);
                low = mid + 1;
            }
            else{ //if right is sorted take min and eliminate..
                ans = Math.min(ans , nums[mid]);
                high = mid - 1;
            }
        }
        return ans;
        
    }
}