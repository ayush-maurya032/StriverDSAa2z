public class BinarySearch{
    public static void main(String[] args) {
        int[] arr = {1,2,3,8,9, 13 ,38,71, 32};
        System.out.println(search(arr, 38));
    }
    public static int search(int[] arr, int target) {
        int n = arr.length;

        int low = 0;
        int high = n -1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(arr[mid] == target){
                return mid;
            }

            else if(target > arr[mid]){
                low = mid + 1;
            }

            else {
                high = mid -1;
            }
        }
       return -1; 
    }
}