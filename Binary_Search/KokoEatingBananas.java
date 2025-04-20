public class KokoEatingBananas{
    public static void main(String[] args) {
        int[] piles = {30,11,23,4,20};
        int hours = 5;
        System.out.println(minEatingSpeed(piles, hours));
    }
    public static int minEatingSpeed(int[] arr, int h) {
        int max = arr[0];
        int ans = max;
        for(int i = 0; i < arr.length; i++){
             max = Math.max(max,arr[i]);
        }
        int low = 1;
        int high = max;
        while(low <= high){
            int mid = low + (high - low) / 2;
            long totalhrs = fun(arr, mid);
            if(totalhrs <= h){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
         return ans;
        }
    
    

        static long fun(int[] arr, int mid){
            long totalh = 0;
            int n = arr.length;
            for(int i=0; i < n; i++){
                //totalh += (int)Math.ceil((double)arr[i]/mid);
                totalh += (arr[i] + mid - 1) / mid; // equivalent to ceil(arr[i] / mid)

            }
            return totalh;
        }
}