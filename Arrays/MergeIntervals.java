import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals{
    public static void main(String[] args) {
        int[][] arr = {{1,3}, {2,6}, {8,9}, {9,11}, {8,10}, {2,4}, {15,18}, {16,17}};

        System.out.println(mergeBrute(arr));
        
    }

    public static List<List<Integer>> mergeBrute(int[][] arr){
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        //Sorting the entire array using lambda expression and comparator
        Arrays.sort(arr, (a,b) -> a[0]-b[0]);

        for(int i = 0; i < n; i++){
            int start = arr[i][0];
            int end = arr[i][1];

            //skip all the already merged intervals 

            if(!ans.isEmpty() && end <= ans.get(ans.size()-1).get(1)){
                continue; 
            }


            //check the rest of the intervals:

            for(int j = i + 1; j < n; j++){
                if(arr[j][0] <= end){
                    end = Math.max(end, arr[j][1]);
                }

                else{
                    break;
                }
            }

            ans.add(Arrays.asList(start,end));

        }





        return ans;
    }
}