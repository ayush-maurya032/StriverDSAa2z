//Gfg/striver:  "Largest subarray with 0 sum"

import java.util.HashMap;

public class SubArrayMaxLen {
    public static void main(String[] args) {
        int[] arr = { 1, -1, 3, 2, -2, -8, 1, 7, 10, 23 };
        System.out.println(maxLenbetter(arr));
        System.out.println(maxLenOptimal(arr));
        
    }

    public static int maxLenbetter(int arr[]) {
        // code here

        int n = arr.length;
        int maxi = 0;
        int cnt = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            cnt = 0;
            sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + arr[j];
                cnt++;
                if (sum == 0) {

                    maxi = Math.max(maxi, cnt);

                }

            }
        }
        return maxi;
    }

    public static int maxLenOptimal(int arr[]) {
        // code here

        int n = arr.length;
        int maxi = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == 0) {
                maxi = i + 1;
            }

            else {

                if (map.get(sum) != null) {
                    maxi = Math.max(maxi, i - map.get(sum));
                }

                else {
                    map.put(sum, i);
                }

            } 

        }
        return maxi;
    }

}