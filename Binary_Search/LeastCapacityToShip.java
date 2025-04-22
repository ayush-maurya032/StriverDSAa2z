public class LeastCapacityToShip{
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(shipWithinDaysbrute(weights, 5));
    }
    public static int shipWithinDaysbrute(int[] weights, int days) {
        int n = weights.length;
        int max = weights[0];
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += weights[i];
            max = Math.max(max,weights[i]);
        }

        for(int cap = max; cap <= sum; cap++){
            int daysRequired = fun(weights, cap);
            if(daysRequired <= days){
                return cap;
            }
        }
        return max;
    }

   static int fun(int[] weights, int capacity){
        int noOfdays = 1; int load = 0;
        for(int i = 0; i < weights.length; i++){
            if(load + weights[i] > capacity){
                noOfdays = noOfdays + 1;
                load = weights[i];
            }
            else{
                load = load + weights[i];
            }
        }
        return noOfdays;
    }


}