import java.util.Scanner;

public class ReverseInteger {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int x = Sc.nextInt();
        int ans = reverse(x);
        System.out.println(ans);
        Sc.close();

    }

    public static int reverse(int n) {
        if (n == 0) {
            return n;
        }
        long reversed = 0;
        while (n > 0) {
            int dig = n % 10;
            reversed = reversed * 10 + dig;
            n = n / 10;
        }
        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) reversed;

    }
}