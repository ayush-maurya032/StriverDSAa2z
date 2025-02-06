import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Union {
    public static void main(String[] args) {
        int n = 10, m = 7;
        int arr1[] = { 1, 2, 7, 4, 5, 12, 7, 8, 9, 10 };
        int arr2[] = { 2, 3, 4, 4, 5, 11, 12 };
        ArrayList<Integer> Union = UnionByHashMap(arr1, arr2);
        System.out.println("Union of arr1 and arr2 is ");
        for (int val : Union)
            System.out.print(val + " ");
    }

    // works on unsorted too.
    public static ArrayList<Integer> UnionByHashMap(int[] arr1, int[] arr2) {

        HashMap<Integer, Integer> freq = new HashMap<>();
        ArrayList<Integer> Union = new ArrayList<>();
        int n = arr1.length;
        int m = arr2.length;
        for (int i = 0; i < n; i++)
            freq.put(arr1[i], freq.getOrDefault(arr1[i], 0) + 1);

        for (int i = 0; i < m; i++)
            freq.put(arr2[i], freq.getOrDefault(arr2[i], 0) + 1);
        for (int it : freq.keySet())
            Union.add(it);
        return Union;

    }

    // works on unsorted too.
    public static ArrayList<Integer> UnionBySet(int[] arr1, int[] arr2) {
        HashSet<Integer> s = new HashSet<>();
        ArrayList<Integer> Union = new ArrayList<>();
        int n = arr1.length;
        int m = arr2.length;
        for (int i = 0; i < n; i++)
            s.add(arr1[i]);
        for (int i = 0; i < m; i++)
            s.add(arr2[i]);
        for (int it : s)
            Union.add(it);

        return Union;
    }

    public static ArrayList<Integer> UnionByTwoPointers(int[] arr1, int[] arr2) {

        int i = 0;
        int j = 0; // Initialising pointers.
        int n = arr1.length;
        int m = arr2.length;
        ArrayList<Integer> Union = new ArrayList<>();

        // Merging Two Arrays Using Two-Pointer Approach

        // Merging Two Arrays Using Two-Pointer Approach
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                if (Union.isEmpty() || Union.get(Union.size() - 1) != arr1[i]) {
                    Union.add(arr1[i]);
                }
                i++; // Always move pointer
            } else {
                if (Union.isEmpty() || Union.get(Union.size() - 1) != arr2[j]) {
                    Union.add(arr2[j]);
                }
                j++;
            }
        }

        // Handling Remaining Elements (After One Array is Exhausted)
        while (i < n) {
            if (Union.isEmpty() || Union.get(Union.size() - 1) != arr1[i]) {
                Union.add(arr1[i]);
            }
            i++;
        }

        while (j < m) {
            if (Union.isEmpty() || Union.get(Union.size() - 1) != arr2[j]) {
                Union.add(arr2[j]);
            }
            j++;
        }

        return Union;
    }

}
