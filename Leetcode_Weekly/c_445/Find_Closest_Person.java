public class Find_Closest_Person{
    public static void main(String[] args) {
        System.out.println(findClosest(2,7,4));
    }
    public static  int findClosest(int x, int y, int z) {
        int xz = Math.abs(x-z);
        int zy = Math.abs(y-z);
        if(xz < zy){
            return 1;
        } 
         if(xz == zy){
             return 0;
         }
        return 2;
     }
}