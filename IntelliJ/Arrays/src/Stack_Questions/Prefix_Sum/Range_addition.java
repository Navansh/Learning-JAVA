package Stack_Questions.Prefix_Sum;

import java.util.Arrays;

public class Range_addition {
    public static void main(String[] args) {
        //Assume you have an array of length n initialized with all 0's and are given k update operations.

        //Each operation is represented as a triplet: [startIndex, endIndex, inc]
        // which increments each element of subarray A[startIndex ... endIndex]
        // (startIndex and endIndex inclusive) with inc.

        //Return the modified array after all k operations were executed.
        int[] arr = new int[8];
        int[][] updates = {
                {1,5,2},
                {2,4,3},
                {0,2,1},
                {3,7,1}
        };

        System.out.println(Arrays.toString(rangeAddition(arr, updates)));

    }

    public static int[] rangeAddition(int[] arr, int[][] updates) {
        //initially the arr contains all 0's

        //now process each change to the array as given in the updates array
        for(int i = 0; i < updates.length; i++) {
            int left = updates[i][0];
            int right = updates[i][1];
            int increment = updates[i][2];

            //add these to the arr
            arr[left] += increment;
            if(right + 1 < arr.length) {
                arr[right + 1] += (-increment);
            }
        }

        //now calculate the prefixSum of this arr, calculating in the same arr only
        for(int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i];
        }

        return arr;
    }
}
