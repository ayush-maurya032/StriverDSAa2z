import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {

        int[] arr = { 2, 5, 7, 8, 0 };
        int target = 9;
        System.out.println(Arrays.toString(twoSumOptimal(arr, target)));

    }

    

    public static int[] twoSumbetter(int[] nums, int target) {
        // for(int i = 0; i < nums.length; i++){
        // for(int j = i+1; j < nums.length; j++){
        // if(nums[i] + nums[j] == target){
        // return new int[] {i,j};
        // }
        // }
        // }
        // return new int[]{-1,-1};
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int moreNeeded = target - num;
            if (mpp.containsKey(moreNeeded)) {
                ans[0] = mpp.get(moreNeeded);
                ans[1] = i;
                return ans;
            }

            mpp.put(nums[i], i);
        }
        return ans;

    }
 
      /// but this will ruin the answer since sorting is done...(only applicable on sorted arrays)
    public static int[] twoSumOptimal(int[] nums, int target) {
        Arrays.sort(nums);
     
        int left = 0;
        int right = nums.length - 1;

        int[] ans = new int[2];
        ans[0] = ans[1] = -1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                return new int[]{left, right}; // Return immediately after finding the answer
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1}; // No solution found
    }
    }
