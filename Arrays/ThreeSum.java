import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4 };
        System.out.println(threeSumBrute(arr));
        System.out.println(threeSumBrute(arr));
        System.out.println(threeSumOptimal(arr));
    }

    public List<List<Integer>> threeSumbrute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i != j && j != k && i != k && nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> listsmall = new ArrayList<>();
                        listsmall.add(nums[i]);
                        listsmall.add(nums[j]);
                        listsmall.add(nums[k]);

                        Collections.sort(listsmall); // Sort to handle duplicates

                        if (!list.contains(listsmall)) { // Avoid duplicate triplets
                            list.add(listsmall);
                        }
                    }
                }
            }
        }
        return list;
    }

    // using hashset to find third
    public static List<List<Integer>> threeSumBrute(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            HashSet<Integer> hashSet = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                // Calculate the third element
                int third = -(nums[i] + nums[j]);

                // find the third element in HashSet

                if (hashSet.contains(third)) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], third);
                    temp.sort(null);
                    set.add(temp);

                }
                hashSet.add(nums[j]);
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }

    // 2 pointer approach
    public static List<List<Integer>> threeSumOptimal(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                    ans.add(temp);
                    j++;
                    k--;

                    // skip the duplicated
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }

                }
            }

        }
        return ans;

    }

}