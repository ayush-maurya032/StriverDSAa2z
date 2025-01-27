public class PalindromeNumber {
    public static void main(String[] args) {
        int n = 121;
        boolean ans = isPalindrome(n);
        System.out.println(ans);
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedhalf = 0;
        while (x > reversedhalf) {
            reversedhalf = reversedhalf * 10 + (x % 10);
            x = x / 10;
        }

        return x == reversedhalf || x == reversedhalf / 10;// check for odd length number like 12321.
    }
}