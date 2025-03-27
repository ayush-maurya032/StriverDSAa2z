// Gfg : Count Subarrays with given XOR

import java.util.HashMap;
import java.util.Map;

public class SubarrayXor {
    public static void main(String[] args) {
        int[] arr = { 4, 2, 2, 6, 4 };
        System.out.println(subarrayXorbetter(arr, 6));
        System.out.println(subarrayXorbrute(arr, 6));
        System.out.println(subarrayXorOptimal(arr, 6));
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

    public static int subarrayXorOptimal(int arr[], int k) {
        // code here
        int n = arr.length;
        int xr = 0;
        // prefix sum like usage here

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            xr = xr ^ arr[i];
            int x = xr ^ k;

            if (map.containsKey(x)) {
                cnt += map.get(x);
            }

            // insert prefix in map till index
            if (map.containsKey(xr)) {
                map.put(xr, map.get(xr) + 1);
            } else {
                map.put(xr, 1);
            }
        }
        return cnt;
    }

}
