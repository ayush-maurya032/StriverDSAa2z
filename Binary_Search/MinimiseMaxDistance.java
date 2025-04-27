import java.util.Scanner;

public class MinimiseMaxDistance {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n = Sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the " + i + "element");
            arr[i] = Sc.nextInt();
        }
        System.out.println("Enter the value of GasStations");
        int gasStations = Sc.nextInt();

        double ans = minimiseBrute(arr, gasStations);
        System.out.println(ans);

    }

    public static double minimiseBrute(int[] arr, int k) {
        int n = arr.length;
        int[] howMany = new int[n - 1];
        for (int gasStation = 1; gasStation <= k; gasStation++) {
            double maxSection = -1;
            int maxIndex = -1;
            for (int i = 0; i < n - 1; i++) {
                double diff = arr[i + 1] - arr[i];
                double secLength = diff / (double) (howMany[i] + 1);

                if (secLength > maxSection) {
                    maxSection = secLength;
                    maxIndex = i;
                }
            }
            howMany[maxIndex]++;
        }

        // finding maxm distance now
        double maxAns = -1;
        for (int i = 0; i < n - 1; i++) {
            double diff = arr[i + 1] - arr[i];
            double secLength = diff / (double) (howMany[i] + 1);
            maxAns = Math.max(maxAns, secLength);
        }

        return maxAns;
    }

}