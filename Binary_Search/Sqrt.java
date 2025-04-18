public class Sqrt{
    public static void main(String[] args) {
        System.out.println(mySqrt(28));
        System.out.println(mySqrt(16));
        System.out.println(mySqrt(-1));
        System.out.println(mySqrt(0));
    }
    public static int mySqrt(int n) {
        long ans  = -1;
        int low = 0;
        int high = n;
        while(low <= high){
            long mid = (low) + (high - low) / 2;
            if(mid * mid <= n){
                ans = mid;
                low = (int)mid + 1;
            }
            
            else{
                high = (int)mid - 1;
            }
        }
    return (int)ans;
    }
}