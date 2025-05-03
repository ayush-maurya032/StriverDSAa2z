public class RemoveOuterMostParenthesis {
    public static void main(String[] args) {
        String s = "(()())(())";
        System.out.println(removeOuterParentheses(s));
    }

    public static String removeOuterParentheses(String s) {
        int cnt = 0;
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ')')
                cnt--;

            if (cnt != 0)
                ans += ch;

            if (ch == '(')
                cnt++;
        }

        return ans;
    }
}