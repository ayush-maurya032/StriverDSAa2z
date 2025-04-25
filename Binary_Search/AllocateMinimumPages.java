public class AllocateMinimumPages {
    public static void main(String[] args) {
        int arr[] = {12, 34, 67, 90}; int k = 2;
        System.out.println(findPages(arr, k));
    }
    public static int findPages(int[] arr, int k) {
        // code here
        int n  = arr.length;
        int max = arr[0];
        int sum = 0;
        if(k > n){
            return -1;
        }
        for(int i = 0; i < n; i++){
            max = Math.max(max,arr[i]);
            sum += arr[i];
        }
        int low = max;
        int high = sum;
        while(low <= high){
            int mid = (low) + (high - low) / 2;
            int noOfStudent = calNoOfStudents(arr,mid);
            if(noOfStudent > k){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return low;
    }
    
    
     static int calNoOfStudents(int[] arr, int target){
        int stu = 1;
        int n = arr.length;
        int pages = 0;
        for(int i = 0; i < n; i++){
            if(pages + arr[i] <= target){
                pages += arr[i];
            }
            else{
                stu++;
                pages = arr[i];
            }
        }
        return stu;
    }
}