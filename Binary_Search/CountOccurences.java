public class CountOccurences{
    public static void main(String[] args) {

        int[] arr = {8,9,10,12,12,12};
        int target = 12;
        int f = first(arr,target);
        int l = last(arr,target);
        
        if(f==-1|| l==-1){
            System.out.println(0);
            
        }
        else{
            int ans= (l - f + 1);
        System.out.println(ans);
        }
       
    }
    
    public static int last(int[] arr, int target){
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] == target){
                ans = mid;
                low = mid + 1;
            
            }
            if(arr[mid] < target){
                low = mid + 1;
            }
            if(arr[mid] > target){
                high = mid -  1;
            }
        }
        
        return ans;
    }
     public static int first(int[] arr, int target){
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] == target){
                ans = mid;
                high = mid - 1;
            
            }
            if(arr[mid] < target){
                low = mid + 1;
            }
            if(arr[mid] > target){
                high = mid - 1;
            }
        }
        
        return ans;
    }

}
