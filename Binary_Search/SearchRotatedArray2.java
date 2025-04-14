public class SearchRotatedArray2{
    public static void main(String[] args) {
        int[] arr = {3,1,2,3,3,3,3};
        System.out.println(search(arr, 1));
    }
    public static boolean search(int[] nums, int target) {
        int n = nums.length;
       int low = 0;
       int high = n -1;
       while(low <= high){
           int mid = low + (high-low) / 2;
           if(nums[mid] == target){
               return true;
           }
           //trim if same i.e duplicate problem will solve
           if(nums[low] == nums[mid] && nums[mid] == nums[high]){
               low++;
               high--;
               continue;
           }

           //left sorted 
           if(nums[low] <= nums[mid]){
               if(nums[low] <= target && target <= nums[mid]){
                   high = mid - 1;
               }
               else{
                   low = mid + 1;
               }
           }
           else { //right sorted
               if(nums[mid] <= target && target <= nums[high]){
                   low = mid + 1;
               }
               else{
                   high = mid - 1;
               }
           }
       }
       return false;
   }
}