import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int[] stalls = { 3, 0, 4, 11, 9, 7 };
        int k = 4;
        System.out.println(aggressiveCows(stalls, k));
        System.out.println(bruteapproach(stalls, k));

    }

    public static int bruteapproach(int[] stalls, int k) {
        Arrays.sort(stalls);
        int n = stalls.length;
        for (int i = 1; i <= (stalls[n - 1] - stalls[0]); i++) {
            if (canWePlace(stalls, i, k) == true) {
                continue;
            } else {
                return i - 1;
            }

        }
        return n;
    }

    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int n = stalls.length;
        int low = 0;
        int high = stalls[n - 1] - stalls[0];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canWePlace(stalls, mid, k) == true) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;

    }

    static boolean canWePlace(int[] stalls, int dist, int cows) {
        int cntCows = 1;
        int last = stalls[0];
        int n = stalls.length;
        for (int i = 1; i < n; i++) {
            if (stalls[i] - last >= dist) {
                cntCows++;
                last = stalls[i];
            }
            if (cntCows >= cows) {
                return true;
            }
        }
        return false;
    }
}