package Weekly_Contest.W_398;

import java.util.Arrays;

public class B_Special_Array_2 {
    public static void main(String[] args) {

    }

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        //queries array is nX2 matrix
        boolean[] ans = new boolean[queries.length];

        //create the partition array
        int[] partitionArray = new int[nums.length];
        //we're directly filling with the increasing numbers

        partitionArray[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] % 2 == nums[i - 1] %2) {
                //meaning the parity is same
                //so start the array's value again from 1
                partitionArray[i] = 1;
            } else {
                //if not then
                partitionArray[i] = partitionArray[i - 1] + 1;
            }
        }
        
        //now we've successfully created the partition array
        //now handle the queries
        for (int i = 0; i < queries.length; i++) {
            int differenceInValues = partitionArray[queries[i][1]] - partitionArray[queries[i][0]];
            int differenceInIndexes = queries[i][1] - queries[i][0];

            ans[i] = differenceInIndexes == differenceInValues;
        }

        return ans;

    }

    public boolean[] isArraySpecialSecond(int[] nums, int[][] queries) {
        //this also works
        if (nums.length == 1) {
            // If there's only one element, every query will be special
            boolean[] result = new boolean[queries.length];
            Arrays.fill(result, true);
            return result;
        }

        // Step 1: Create a parity change array
        boolean[] parityChanges = new boolean[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            parityChanges[i] = (nums[i] % 2) != (nums[i + 1] % 2);
        }

        // Step 2: Create a prefix sum array for the parity change array
        int[] prefixSum = new int[parityChanges.length];
        prefixSum[0] = parityChanges[0] ? 1 : 0;
        for (int i = 1; i < parityChanges.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + (parityChanges[i] ? 1 : 0);
        }

        // Step 3: Answer each query using the prefix sum array
        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            if (start == end) {  // Single element subarray is always special
                result[i] = true;
                continue;
            }

            int changes;
            if (start == 0) {
                changes = prefixSum[end - 1];
            } else {
                changes = prefixSum[end - 1] - prefixSum[start - 1];
            }

            // If the number of changes is equal to the length of the subarray minus 1, it's special
            result[i] = (changes == (end - start));
        }

        return result;
    }
}
