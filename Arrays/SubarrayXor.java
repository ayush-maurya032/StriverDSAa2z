// Gfg : Count Subarrays with given XOR

public class SubarrayXor {
    public static void main(String[] args) {
        int[] arr = { 4, 2, 2, 6, 4 };
        System.out.println(subarrayXorbetter(arr, 6));
        System.out.println(subarrayXorbrute(arr, 6));
    }

    public static int subarrayXorbrute(int arr[], int k) {
        // code here
        int n = arr.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int xor = 0;
                for (int l = i; l <= j; l++) {
                    xor = xor ^ arr[l];

                }
                if (xor == k) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static int subarrayXorbetter(int arr[], int k) {
        // code here
        int n = arr.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int xor = 0;
            for (int j = i; j < n; j++) {
                xor = xor ^ arr[j];
                if (xor == k) {
                    cnt++;
                }
            }
        }
        return cnt;
    }




}
