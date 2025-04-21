public class MinDaysMBouquets {
    public static void main(String[] args) {
      int[] bloomDay = {7,7,7,7,12,7,7};
      int m= 2;
      int k = 3;
      System.out.println(minDaysBloombrute(m, k, bloomDay));
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
   
}