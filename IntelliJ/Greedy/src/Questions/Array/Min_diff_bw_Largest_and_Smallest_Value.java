package Questions.Array;

import java.util.Arrays;

public class Min_diff_bw_Largest_and_Smallest_Value {
    public static void main(String[] args) {
        //https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
    }

    public int minDifference(int[] nums) {
        //sort first
        Arrays.sort(nums);

        //shuru ke 3 min ko max bana do
        //last ke 3 max ko min bana do
        //shuru ke 2 ko change and last ke 1 ko change
        //shuru ke 1 ko change and last ke 2 ko change

        int n = nums.length;
        int min = Integer.MAX_VALUE;

        if(nums.length <= 3) {
            //change all these to 0 or to any same value
            return 0;
        }

        for (int i = 1; i <= 4 ; i++) {
            //ye 4 cases explore kar rhe upar waale
            min = Math.min(min, Math.abs(nums[n - i] - nums[4 - i]));
            //we check difference between the max index
            //and the min index's values
            //and this we got to know using the 4 testcases we made
        }

        return min;
    }
}
