//Print any given Row

public class PascalTriangleQ2 {
    public static void main(String[] args) {
        brute(5);
        optimal(7);
    }

    public static int nCr(int n, int r) {
        int res = 1;
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);

        }
        return (int) res;

    }

    public static void brute(int n) {
        for (int c = 1; c <= n; c++) {
            System.out.println(nCr(n - 1, c - 1));
        }
    }

    public static void optimal(int n) {
        int ans = 1;
        System.out.println(ans);
        for (int c = 1; c <= n; c++) {
            ans = ans * (n - c);
            ans = ans / c;
            System.out.print(ans + " ");
        }
    }
}