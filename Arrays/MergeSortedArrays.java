import java.util.Arrays;
//This code works on the striver question but leetcode question is different but can be modified for leetcode question too 
public class MergeSortedArrays{
    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,5,6};
        mergeBrute(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        
    }
    public static void mergeBrute(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[n + m];
        int i = 0;
        int j = 0;
        int k = 0;
  
        while( i < m && j < n){
          if(nums1[i] <= nums2[j]){
              nums3[k] = nums1[i];
              i++;
              k++;
          }
          else{
              nums3[k] = nums2[j];
              j++;
              k++;
          }
        }
  
        while(i < m){
          nums3[k] = nums1[i];
          i++;
          k++;
        }
  
        while(j < n){
          nums3[k] = nums2[j];
          j++;
          k++;
        }
      
        for( i = 0; i < m + n; i++){
          if(i < m){
            nums1[i] = nums3[i];
          }
          else{
            nums2[i-n] = nums3[i];
          }
        }
  
  
  
  
      }



     

}