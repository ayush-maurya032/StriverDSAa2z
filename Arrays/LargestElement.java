
public class LargestElement {
    public static void main(String[] args) {
        int[] arr = { 1,34,53,0,-8,9,90};
        int ans = largest(arr);
        System.out.println(ans);


    }
        
    

    
    public static int largest(int[] arr) {
            // code here
            
            int max = arr[0];
            for(int i =0; i < arr.length; i++){
                if(arr[i] >= max){
                    max =arr[i];
                }
            }
            
            return max;
            
        }
    
}

