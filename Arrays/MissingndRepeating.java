//Striver and Gfg
// Missing and Repeating

import java.util.Arrays;

public class MissingndRepeating{
    public static void main(String[] args) {
        int[] arr = {4,3,6,2,1,1};
        System.out.println(Arrays.toString(brute(arr)));
        System.out.println(Arrays.toString(better(arr)));
        System.out.println(Arrays.toString(optimal1(arr)));
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

    public static int[] better(int[] arr){
        int n = arr.length;
        int a = -1;
        int b = -1;
        int[] hasharr = new int[n + 1];
        
        for(int i = 0; i < n; i++){
            int index = arr[i];
            hasharr[index]++;
        }
        
        for(int i = 1; i < n + 1; i++){
            if(hasharr[i] == 0){
                a = i;
            }
            if(hasharr[i] > 1){
                b = i;
            }
        }
        
        return new int[] {b,a};
    }



    public static int[] optimal1(int[] arr){
        int n = arr.length;
        //s - sn ---> x -y
        //s2 - s2n --- x+y.x-y
       

        long s = 0;
        long s2n = n * (n + 1) * (2*n + 1) / 6;
        long sn = n*(n+1) / 2; 
        long s2 = 0;
       for(int i = 0; i < n; i++){
          s += arr[i];
          s2 += arr[i]*arr[i];
       }

       long val1 = s - sn;
       long val2 = s2 - s2n;
       val2 = val2 / val1;

       long x = (val1 + val2 ) / 2;
       long y = x - val1;

        return new int[] {(int)x, (int)y};
    }
}