/* LeetCode 152. Maximum Product Subarray
The brute  and better force approach is same as maximum sum subarray with o(ncube) and o(nsquare)
The Optimal approaches include a intution based logical approach and other using Kadane's .
Kadane is less intuitive. So will take the logical and intuitive approach here.
*/
public class MaximumProductSubarray{
    public static void main(String[] args) {
        int[] array = {2,3,-2,4};
        System.out.println(maxProductSubArray(array));
        
    }

    public static int maxProductSubArray(int[] arr) {
        int n = arr.length; //size of array.

        int pre = 1, suff = 1;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (pre == 0) pre = 1;
            if (suff == 0) suff = 1;
            pre *= arr[i];
            suff *= arr[n - i - 1];
            ans = Math.max(ans, Math.max(pre, suff));
        }
        return ans;
    }

}
