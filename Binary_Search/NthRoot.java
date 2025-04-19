public class NthRoot{
    public static void main(String[] args) {
        System.out.println(nthRoot(4,69));
        System.out.println(nthRoot(3, 27));


    }
     public static int nthRoot(int n, int m) {
        // code here
        int low = 1;
        int high = m;
        while(low <= high){
            int mid = low + (high - low) / 2;
            long ans = (long)Math.pow(mid , n);
            if(ans == m){
                return mid;
            }
            else if(ans < m){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }       

}

