//Here we print a specific element with formula : r-1Nc-1
public class PascalTriangleQ1 {
    public static void main(String[] args) {
        System.out.println(brute(5, 3));
        System.out.println(optimal(5, 4));
    }

    public static int factorial(int num) {
        int fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }

    // Function to calculate nCr using the factorial formula
    public static int brute(int n, int r) {
        if (r > n)
            return 0; // Invalid case
        int num = factorial(n); // n!
        int den = factorial(r) * factorial(n - r); // r! * (n-r)!
        return num / den; // nCr formula
    }

    public static int optimal(int n, int r) {
        int res = 1;
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);

        }
        return (int) res;

    }

}