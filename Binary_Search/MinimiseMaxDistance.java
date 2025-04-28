import java.util.PriorityQueue;
import java.util.Scanner;

public class MinimiseMaxDistance {
    public static class Pair {
        double first;
        int second;

        Pair(double first, int second) {
            this.first = first;
            this.second = second;

        }
    }

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

        double ans = minimiseBetter(arr, gasStations);
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

    public static double minimiseBetter(int[] arr, int k) {
        int n = arr.length;
        int howMany[] = new int[n - 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.first, a.first));
        // insert the n-1 elements into pq, wrt to respective distance values

        for (int i = 0; i < n - 1; i++) {
            pq.add(new Pair((arr[i + 1] - arr[i]), i));
        }

        // pick and place gas stations.

        for (int gasStation = 1; gasStation <= k; gasStation++) {
            // find max section and then insert the gs

            Pair tcp = pq.poll();
            int secInd = tcp.second;

            // insert the current gas station
            howMany[secInd]++;

            double diff = arr[secInd + 1] - arr[secInd];
            double newSecLen = diff / ((double) (howMany[secInd] +
                    1));

            pq.add(new Pair(newSecLen, secInd));

        }
        return pq.peek().first;
    }

    public static double minimiseOptimal(int[] arr, int k) {
        double low = 0;
        double high = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            high = Math.max(high, (double) (arr[i + 1] - arr[i]));
        }
        double ans = 0.0;
        double diff = 1e-6;
        while (high - low > diff) {
            double mid = (low + high) / 2.0;
            int cnt = numberofGasStation(mid, arr);
            if (cnt > k) {
                low = mid;
            } else {
                ans = high;
                high = mid;
            }

        }
        return high;
    }

    static int numberofGasStation(double dist, int[] arr) {
        int cnt = 0;
        for (int i = 1; i < arr.length; i++) {
            int numberInBetween = arr[i + 1] - arr[i];
            if ((arr[i + 1] - arr[i]) / dist == numberInBetween * dist) {
                numberInBetween--;
            }
            cnt += numberInBetween;

        }
        return cnt;
    }

}