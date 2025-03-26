import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {
    public static void main(String[] args) {
        int[] arr = { -1, 0, -1, 0, -2, 2 };
        System.out.println(fourSumBetter(arr, 0));
    }

    public static List<List<Integer>> fourSumBetter(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Long> hashset = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    long sum = nums[i] + nums[j];
                    sum += nums[k];
                    long fourth = target - sum;

                    if (hashset.contains(fourth)) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add((int) fourth);
                        Collections.sort(temp);
                        set.add(temp);

                    }
                    hashset.add((long) nums[k]);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;

    }

    public static void foursumOptimal(int[] arr) {

    }
}