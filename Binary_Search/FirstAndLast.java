import java.util.Arrays;

public class FirstAndLast {
    public static void main(String[] args){

        int[] nums = {2,4,6,8,8,8,11,13};
        int target = 8;
        int first = findFirstOccurrence(nums, target);//its simply lower bound 
        int last = findLastOccurrence(nums, target); // its simply upper bound 
        System.out.println(Arrays.toString(new int[] {first, last}));
    }

    public  static int findFirstOccurrence(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                ans = mid;
                high = mid - 1; // continue to search on the left
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int findLastOccurrence(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                ans = mid;
                low = mid + 1; // continue to search on the right
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
