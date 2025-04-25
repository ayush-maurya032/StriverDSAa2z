public class PaintersPartition {
    public static void main(String[] args) {
        int arr[] = { 5, 10, 30, 20, 15 }, k = 3;
        System.out.println(minTime(arr, k));
    }

    public static int minTime(int[] nums, int k) {
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
            int noOfPainters = fun(nums, mid);
            if (noOfPainters > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;

    }

    static int fun(int[] arr, int target) {
        int noOfPainters = 1;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] <= target) {
                sum += arr[i];
            } else {
                noOfPainters++;
                sum = arr[i];
            }
        }
        return noOfPainters;
    }
}