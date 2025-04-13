public class SmallestPalindromicRearrangement1{
    public static void main(String[] args) {
        String s = "daccad";
        System.out.println(smallestPalindrome(s));
    }
    public static String smallestPalindrome(String s) {
        int[] letterCount = new int[26];
        for(char ch : s.toCharArray()){
            letterCount[ch - 'a']++;
        }
        StringBuilder left = new StringBuilder();
         StringBuilder middle = new StringBuilder();

        for(int i = 0; i < 26; i++){
            int count = letterCount[i];
            if(count % 2 != 0){
                middle.append((char)(i + 'a'));
            }

            for(int j = 0; j < count / 2; j++){
                left.append((char)(i + 'a'));
            }
        }
        StringBuilder result = new StringBuilder();
        result.append(left);
        result.append(middle);
        result.append(left.reverse());


        return result.toString();
    }
}