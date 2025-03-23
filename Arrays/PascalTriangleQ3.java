
//Printing Entire Pascal Triangle for the given N
import java.util.ArrayList;
import java.util.List;

public class PascalTriangleQ3 {
    public static void main(String[] args) {
        System.out.println(brute(6));
        System.out.println(optimal(6));
    }

    public static ArrayList<ArrayList<Integer>> brute(int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int row = 1; row <= n; row++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int col = 1; col <= row; col++) {
                list.add(funNcR(row - 1, col - 1));
            }
            ans.add(list);
        }
        return ans;
    }

    public static int funNcR(int r, int c) {
        int res = 1;
        for (int i = 0; i < c; i++) {
            res = res * (r - i);
            res = res / (i + 1);

        }
        return (int) res;

    }

    public static List<List<Integer>> optimal(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            ans.add(generateRow(i));
        }
        return ans;

    }

    public static List<Integer> generateRow(int row) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1);

        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            ansRow.add((int) ans);
        }
        return ansRow;
    }

}