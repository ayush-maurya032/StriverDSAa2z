/*Leetcode 2149. Rearrange Array elements by Sign */

import java.util.Arrays;

public class RearrangeArray{
    public static void main(String[] args){
    int[] nums = {3,1,-2,-5,2,-4};
    //rearrangebrute(nums);
   // System.out.println(Arrays.toString(nums));
    System.out.println(Arrays.toString(rearrange(nums)));
    }

    public static void rearrangebrute(int[] nums){
        int n = nums.length;
        int[] posArray = new int[n/2];
        int p =0;
        int ne =0;
        int[] negArray = new int[n/2];

        //Segrating neg and pos elements
        for(int i = 0; i < n; i++){
            if(nums[i] > 0){
                posArray[p] = nums[i];
                p++;
            }
            else{
                negArray[ne] = nums[i];
                ne++;
            }

        }

        for(int i = 0; i < n/2; i++){
            nums[2*i] = posArray[i];
            nums[2*i + 1] = negArray[i];
        }
    }


    public static int[] rearrange(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        int pos = 0; int neg = 1;
        for(int i = 0; i < n; i++){
            if(nums[i] < 0){
                ans[neg] = nums[i];
                neg += 2;
            }
            else{
                ans[pos] = nums[i];
                pos += 2;
            }
        }

        return ans;
    }


}