import java.util.Scanner;

public class CheckSorted {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.println("enter 10 numbers");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Sc.nextInt();
        }
        System.out.println(check(arr));
        Sc.close();

    }

        public static boolean check(int[] arr){
            for(int i =1; i<arr.length;i++){
                if(arr[i]<arr[i-1]){
                  return false;
                }
            }
            return true;
        }
    
    
}
