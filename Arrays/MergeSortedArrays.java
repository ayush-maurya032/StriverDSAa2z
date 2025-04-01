import java.util.Arrays;
//This code works on the striver question but leetcode question is different but can be modified for leetcode question too 
public class MergeSortedArrays{
    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,5,6};
        //mergeBrute(nums1,3,nums2,3);
        //mergeOptimal1(nums1, nums2, 3, 3);
        mergeOptimal2(nums1,nums2,3,3);
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

      public static void mergeOptimal1(int[] arr1, int[] arr2, int n, int m){
        int left = n - 1;
        int right = 0;

        while(left >= 0 && right < m){
          if(arr1[left] >arr2[right]){
            int temp = arr1[left];
            arr1[left]= arr2[right];
            arr2[right] = temp;
            left--;
            right++;
          }
          else{
            break;
          }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
      }


      //Gap Method...

      public static void mergeOptimal2(int[] arr1, int[] arr2, int n , int m){
        
        // len of the imaginary single array:
        int len = n + m;

        // Initial gap:
        int gap = (len / 2) + (len % 2);

        while (gap > 0) {
            // Place 2 pointers:
            int left = 0;
            int right = left + gap;
            while (right < len) {
                // case 1: left in arr1[]
                //and right in arr2[]:
                if (left < n && right >= n) {
                    swapIfGreater(arr1, arr2, left, right - n);
                }
                // case 2: both pointers in arr2[]:
                else if (left >= n) {
                    swapIfGreater(arr2, arr2, left - n, right - n);
                }
                // case 3: both pointers in arr1[]:
                else {
                    swapIfGreater(arr1, arr1, left, right);
                }
                left++; right++;
            }
            // break if iteration gap=1 is completed:
            if (gap == 1) break;

            // Otherwise, calculate new gap:
            gap = (gap / 2) + (gap % 2);
        }
    }

      public static void swapIfGreater(int[] arr1, int[] arr2, int ind1, int ind2) {
        if (arr1[ind1] > arr2[ind2]) {
            int temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }



     

}