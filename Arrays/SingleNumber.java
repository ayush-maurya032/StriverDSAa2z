import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SingleNumber {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        System.out.println("Enter the limit");
        int n = Sc.nextInt();

        int[] arr = new int[n];
        System.out.println("enter numbers");
        for (int i = 0; i < n; i++) {
            arr[i] = Sc.nextInt();
        }

        
        System.out.println(singleNumberBrute(arr));
        System.out.println(singleNumberBetter1(arr));
        System.out.println(singleNumberBetter2(arr));
        System.out.println(singleNumberOptimal(arr));
       Sc.close();
    }

    public static int singleNumberBrute(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            int count = 0;
            
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == num)
                    count++;
            }
            if(count == 1){
                return num;
            }
        }
        return -1;
    }

    // won't work on neggative elements in array ...
    //using hasharray
    public static int singleNumberBetter1(int[] nums) {
        int maxElement = nums[0];
        
        for(int i = 0; i < nums.length; i++){

          maxElement = Math.max(nums[i], maxElement);


        }
        int hasharray[] = new int[maxElement + 1];
        for(int i = 0; i < nums.length; i++){
            hasharray[nums[i]]++;
        }

        
        for(int i = 0; i < nums.length; i++){
            if(hasharray[nums[i]] == 1){
                return nums[i];
            }
        }
        return -1;
    }


    //usinh Hashmap data structure...
    public static int singleNumberBetter2(int[] nums){
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0; i < n; i++){
            int value = map.getOrDefault(nums[i], 0);
            map.put(nums[i], value + 1);
        }

        for(Map.Entry<Integer, Integer> it : map.entrySet()){
            if(it.getValue() == 1){
                return it.getKey();
            }
        }
        return -1;
    }


    public static int singleNumberOptimal(int[] nums){
        int n = nums.length;

        // XOR all the elements:
        int xorr = 0;
        for (int i = 0; i < n; i++) {
            xorr = xorr ^ nums[i];
        }
        return xorr;
    }


    }


