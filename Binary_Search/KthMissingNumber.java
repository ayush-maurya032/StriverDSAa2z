public class KthMissingNumber{
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        System.out.println(brute(arr, 5));
    }
    public static int brute(int[] arr, int k){
        int n  = arr.length;
        for(int i = 0; i < n; i++){
            if(arr[i] <= k){
                k++;
            }
            else{
                break;
            }
        }
        return k;
    }
    }
