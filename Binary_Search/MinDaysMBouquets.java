public class MinDaysMBouquets {
    public static void main(String[] args) {
      int[] bloomDay = {7,7,7,7,12,7,7};
      int m= 2;
      int k = 3;
      System.out.println(minDaysBloombrute(m, k, bloomDay));
      System.out.println(minDaysOptimal(bloomDay, m, k));
    }

    public static int minDaysBloombrute(int m, int k, int[] bloomDay) {
        int n = bloomDay.length;
           if(n < m*k){
               return -1;
           }
           int min = Integer.MAX_VALUE;
           int max = Integer.MIN_VALUE;
           
           int finalans = -1;
   
           for(int i = 0; i < n; i++){
               min = Math.min(min , bloomDay[i]);
               max = Math.max(max, bloomDay[i]);
           }
   
           for(int i = min; i <= max; i++){
               if(possible(bloomDay,i,m , k ) == true){
                   return i;
               }
           }
           
           return -1;
        }

        static boolean possible(int[] arr, int day, int m , int k){
            int cnt = 0;
            int noOfB = 0;
            for(int i = 0; i < arr.length; i++){
                if(arr[i] <= day){
                    cnt++;
                }
                else{
                    noOfB += cnt / k;
                    cnt = 0;
                }
            }
    
                noOfB += cnt / k;
                if(noOfB >= m){
                    return true;
                }
    
                return false;
        }






     public static  int minDaysOptimal(int[] bloomDay, int m, int k) {
            int n = bloomDay.length;
            if(n < m*k){
                return -1;
            }
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            
            int finalans = -1;
    
            for(int i = 0; i < n; i++){
                min = Math.min(min , bloomDay[i]);
                max = Math.max(max, bloomDay[i]);
            }
    
            // for(int i = min; i <= max; i++){
            //     if(possible(bloomDay,i,m , k ) == true){
            //         return i;
            //     }
            // }
            // return -1;
    
            int low = min;
            int high = max;
            while(low <= high){
                int mid = low + (high - low) / 2;
               int bouquets = possible1(bloomDay, mid, m ,k);
                if( bouquets >= m){
                    finalans = mid;
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
                
            }
            return finalans;
        }
    
       static  int possible1(int[] arr, int day, int m , int k){
            int cnt = 0;
            int noOfB = 0;
            for(int i = 0; i < arr.length; i++){
                if(arr[i] <= day){
                    cnt++;
                }
                else{
                    noOfB += cnt / k;
                    cnt = 0;
                }
            }
    
                noOfB += cnt / k;
    
                return noOfB;
        }
   
}