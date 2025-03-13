
//169. Majority Element
//Leetcode nd Striver

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MajorityElement {
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
        System.out.println(majorityElementbrute(arr));
    }

    public static int majorityElementbrute(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int value = map.getOrDefault(nums[i], 0);
            map.put(nums[i], value + 1);
        }

        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            if (it.getValue() > n / 2) {
                return it.getKey();
            }
        }

        return -1;
    }

    // Moore's Voting Algo
    public static int majorityElementOptimal(int[] nums) {

        int n = nums.length;
        int cnt = 0;
        int el = 0;
        for (int i = 0; i < n; i++) {
            if (cnt == 0) {
                cnt = 1;
                el = nums[i];
            }

            else if (nums[i] == el) {
                cnt++;
            }

            else {
                cnt--;
            }
        }

        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == el) {
                cnt1++;
            }
        }
        //if and only if problem says there may or may not be a majority then check
        if (cnt1 > n / 2) {
            return el;
        }

        return -1;

    }

}
