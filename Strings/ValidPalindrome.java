

public class ValidPalindrome {
public static void main(String[] args) {
    String s = "Ac3?e3c&a";
    System.out.println(isPalindrome(s));
    
}
public static boolean isAlphanumeric(char ch){
    if ((ch >= '0' && ch <= '9') ||
            (Character.toLowerCase(ch) >= 'a' && Character.toLowerCase(ch) <= 'z')) {
            return true;
        }
        return false;
   }




    public static  boolean isPalindrome(String s) {
        int n = s.length();
        int st = 0;
        int end = n - 1;
        while(st < end){
            if(!isAlphanumeric(s.charAt(st))){
                st++;
                continue;
            }
            if(!isAlphanumeric(s.charAt(end))){
                end--;
                continue;
            }
            
            if(Character.toLowerCase(s.charAt(st)) != Character.toLowerCase(s.charAt(end))){
                return false;
            }

            st++;
            end--;
        }
       return true; 
    }

    
}
