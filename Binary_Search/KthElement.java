public class KthElement {
    public static void main(String[] args) {
        int[] a = { 2, 3, 6, 7, 9 };
        int[] b = { 1, 4, 8, 10 };
        int k = 5;
        System.out.println(optimal(a, b, k));
    }

    public static int optimal(int[] a, int[] b, int k) {
        int n1 = a.length;
        int n2 = b.length;
        if (n1 > n2) {
            return optimal(b, a, k);
        }

        int left = k;
        int low = Math.max(k - n2, 0);
        int high = Math.min(k, n1);

        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;

            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            if (mid1 < n1)
                r1 = a[mid1];
            if (mid2 < n2)
                r2 = b[mid2];

            if (mid1 - 1 >= 0)
                l1 = a[mid1 - 1];
            if (mid2 - 1 >= 0)
                l2 = b[mid2 - 1];

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            }

            else if (l1 > l2) {
                high = mid1 - 1;
            }

            else {
                low = mid1 + 1;
            }
        }
        return 0;
    }
}