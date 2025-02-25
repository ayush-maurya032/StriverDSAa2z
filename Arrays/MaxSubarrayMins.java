//GFG
//Maximum Score from Subarray Minimums
// Difficulty: MediumAccuracy: 43.26%Submissions: 104K+Points: 4
// Given an array arr[], with 0-based indexing, select any two indexes, i and j such that i < j. From the subarray arr[i...j], select the smallest and second smallest numbers and add them, you will get the score for that subarray. Return the maximum possible score across all the subarrays of array arr[].

// Examples :

// Input : arr[] = [4, 3, 1, 5, 6]
// Output : 11
public class MaxSubarrayMins {

    public static void main(String[] args) {
        int[] arr = {4, 3, 1, 5, 6};
        System.out.println(maxScoreBruteForce(arr));
        System.out.println(maxScorebetter(arr));
    }

    public static int maxScoreBruteForce(int[] arr) {
        int n = arr.length;
        int maxScore = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // Find the smallest and second smallest in subarray [i...j]
                int smallest = Integer.MAX_VALUE;
                int secondSmallest = Integer.MAX_VALUE;

                for (int k = i; k <= j; k++) {
                    if (arr[k] < smallest) {
                        secondSmallest = smallest;
                        smallest = arr[k];
                    } else if (arr[k] < secondSmallest) {
                        secondSmallest = arr[k];
                    }
                }

                if (secondSmallest != Integer.MAX_VALUE) {
                    maxScore = Math.max(maxScore, smallest + secondSmallest);
                }
            }
        }

        return maxScore;
    }


    public static int maxScorebetter(int[] arr) {
        int n = arr.length;
        int maxScore = 0;

        for (int i = 0; i < n; i++) {
            int smallest = Integer.MAX_VALUE;
            int secondSmallest = Integer.MAX_VALUE;

            for (int j = i; j < n; j++) {
                // Update the smallest and second smallest dynamically
                if (arr[j] < smallest) {
                    secondSmallest = smallest;
                    smallest = arr[j];
                } else if (arr[j] < secondSmallest) {
                    secondSmallest = arr[j];
                }

                if (secondSmallest != Integer.MAX_VALUE) {
                    maxScore = Math.max(maxScore, smallest + secondSmallest);
                }
            }
        }

        return maxScore;
    }

}