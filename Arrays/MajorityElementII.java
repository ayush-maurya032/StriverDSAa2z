//229. Majority Element II
//Leetcode nd Striver

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MajorityElementII {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        System.out.println("Enter the limit");
        int n = Sc.nextInt();

        int[] arr = new int[n];
        System.out.println("enter numbers");
        for (int i = 0; i < n; i++) {
            arr[i] = Sc.nextInt();
        }
        System.out.println();
        System.out.println("answer is:");
        System.out.println(majorityElementOptimal(arr));
        System.out.println(majorityElementbetter(arr));
        Sc.close();
    }

    public static List<Integer> majorityElementbetter(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        // storing in Hashmap
        for (int i = 0; i < n; i++) {
            int value = map.getOrDefault(nums[i], 0);
            map.put(nums[i], value + 1);
        }

        // Searching in HashMap
        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            if (it.getValue() > (n / 3)) {
                list.add(it.getKey());
            }

        }

        return list;
    }

    // Moore's Voting Algo
    public static List<Integer> majorityElementOptimal(int[] nums) {

        ArrayList<Integer> list = new ArrayList<>();

        int n = nums.length;

        int cnt1 = 0;
        int cnt2 = 0;
        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && nums[i] != el2) {
                cnt1 = 1;
                el1 = nums[i];
            }

            else if (cnt2 == 0 && nums[i] != el1) {
                cnt2 = 1;
                el2 = nums[i];
            }

            else if (el1 == nums[i]) {
                cnt1++;
            } else if (el2 == nums[i]) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        // final count since cnt1 and cnt2 are occurences not correct count.
        for (int num : nums) {
            if (num == el1)
                cnt1++;
            else if (num == el2)
                cnt2++;
        }

        // Check if they appear more than n/3 times
        if (cnt1 > n / 3)
            list.add(el1);
        if (cnt2 > n / 3)
            list.add(el2);

        return list;

    }

}