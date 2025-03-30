import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals{
    public static void main(String[] args) {
        int[][] arr = {{1,3}, {2,6}, {8,9}, {9,11}, {8,10}, {2,4}, {15,18}, {16,17}};

        System.out.println(mergeBrute(arr));
        int[][] array = mergeOptimal(arr);

        for(int i = 0; i < array.length;i++){
            System.out.println(Arrays.toString(array[i]));
        }
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



    public static int[][] mergeOptimal(int[][] arr){
        int n = arr.length;
        Arrays.sort(arr, (a,b) -> a[0] - b[0]);


        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){

            //if the current interval class does not lie in the last interval  
            if(ans.isEmpty() || arr[i][0] > ans.get(ans.size()-1).get(1)){
                ans.add(Arrays.asList(arr[i][0], arr[i][1]));
            }  
            
            else{
                //if the current interval lies inthe last interval
                ans.get(ans.size()-1).set(1,Math.max(ans.get(ans.size()-1).get(1), arr[i][1]));
            }
        }

        int[][] result = new int[ans.size()][2]; // Assuming pairs of integers

        for (int i = 0; i < ans.size(); i++) {
            result[i][0] = ans.get(i).get(0);
            result[i][1] = ans.get(i).get(1);
        }
            return result;
        
        
    }
}