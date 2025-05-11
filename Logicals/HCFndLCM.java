import java.util.Arrays;
import java.util.Scanner;

public class HCFndLCM {
    public static void main(String[] args) {

        try (Scanner Sc = new Scanner(System.in)) {
            System.out.println("Enter two numbers");
            int a = Sc.nextInt();
            System.out.println();
            int b = Sc.nextInt();
            int[] ans = optimal(a, b);
            System.out.println(Arrays.toString(ans));
        }

        
    }

    public static int[] brute(int a, int b) {

        int min = Math.min(a, b);
        int hcf = 1;
        for (int i = 1; i <= min; i++) {

            if (a % i == 0 && b % i == 0) {
                hcf = i;
            }

        }
        int lcm = a * b / hcf;

        return new int[] { hcf, lcm };

    }

    public static int[] better(int a, int b) {

        int min = Math.min(a, b);
        int hcf = 1;
        for (int i = min; i > 0; i--) {

            if (a % i == 0 && b % i == 0) {
                hcf = i;
                break;
            }

        }

        int lcm = a * b / hcf;

        return new int[] { hcf, lcm };

    }

    public static int[] optimal(int a, int b) {
        // Here we are using Euclidean algorithm
        // The Euclidean Algorithm is a method for finding the greatest common divisor
        // of two numbers. It operates on the principle that the GCD of two numbers
        // remains the same even if the smaller number is subtracted from the larger
        // number.

        // To find the GCD of n1 and n2 where n1 > n2:

        // Repeatedly subtract the smaller number from the larger number until one of
        // them becomes 0.
        // Once one of them becomes 0, the other number is the GCD of the original
        // numbers.
        // Eg, n1 = 20, n2 = 15:

        // gcd(20, 15) = gcd(20-15, 15) = gcd(5, 15)

        // gcd(5, 15) = gcd(15-5, 5) = gcd(10, 5)

        // gcd(10, 5) = gcd(10-5, 5) = gcd(5, 5)

        // gcd(5, 5) = gcd(5-5, 5) = gcd(0, 5)

        // Hence, return 5 as the gcd.
        int aa = a;
        int bb = b;
        while (a != 0) {
            int min = Math.min(a, b);
            int max = a + b - min;
            a = max - min;
            b = min;
        }
        int hcf = b;
        int lcm = aa * bb / hcf;
        return new int[] { hcf, lcm };
    }

}
