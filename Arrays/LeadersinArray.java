//GFG(Array Leaders) /STRIVER array medium level 

import java.util.ArrayList;
import java.util.Collections;

public class LeadersinArray{
    public static void main(String[] args) {
        int[] arr = {200,43,99,178,12,0,6,7,87,87};
        System.out.println(leaders(arr));
    }
    public static ArrayList<Integer> leaders(int arr[]) {
        // code 
        ArrayList<Integer> list = new ArrayList<>();
        int maxi = Integer.MIN_VALUE;
        
        int n = arr.length;
        
        for(int i = n-1; i>=0; i--){
            if(arr[i] >= maxi){
                maxi = arr[i];
                list.add(arr[i]);
            }
            
            
            
        }
        Collections.reverse(list);
        return list;
    }
}