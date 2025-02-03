public class CheckSortedandRotated {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        System.out.println(check(arr));
    }

    public static boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;
        for(int i =0; i<n;i++){
            // Compare the current element with the next one (wrap around with modulo)
            if (nums[i] > nums[(i + 1) % n]) {
                count++;  // If there's a drop, increment the counter
            }
        }
         // Return true if there's at most one drop, otherwise false
        return count <= 1;
    }
}
