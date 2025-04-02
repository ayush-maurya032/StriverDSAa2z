//Striver and Gfg
// Missing and Repeating

import java.util.Arrays;

public class MissingndRepeating{
    public static void main(String[] args) {
        int[] arr = {4,3,6,2,1,1};
        System.out.println(Arrays.toString(brute(arr)));
    }

    public static int[] brute(int[] arr){
        int n = arr.length;
        int missing = -1;
        int repeating = -1;
        int cnt = 0;
         
        for(int i = 1; i <= n; i++){

            cnt = 0;
            for(int j = 0; j < n; j++){
                if(arr[j] == i){
                    cnt++;
                }
            }
            if(cnt == 2){
                repeating = i;

            }
            else if(cnt == 0){
                missing = i;
            }

            if(missing != -1 && repeating != -1){
                break;
            }
        }
     return new int[] {repeating, missing};
    }
}