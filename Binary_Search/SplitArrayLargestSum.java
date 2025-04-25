public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = { 7, 2, 5, 10, 8 };
        int k = 2;
        System.out.println(splitArray(nums, k));
    }

    public static int splitArray(int[] nums, int k) {
        int n = nums.length;
        int max = nums[0];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            sum += nums[i];
        }
        int low = max;
        int high = sum;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int noOfSubarrays = fun(nums, mid);
            if (noOfSubarrays > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;

    }

    static int fun(int[] arr, int target) {
        int noOfSubarrays = 1;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] <= target) {
                sum += arr[i];
            } else {
                noOfSubarrays++;
                sum = arr[i];
            }
        }
        return noOfSubarrays;
    }
}