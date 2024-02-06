package Questions;

public class Range_Sum_Query {
    public static void main(String[] args) {
    //https://leetcode.com/problems/range-sum-query-immutable/
    }
}

class NumArray {
    int[] prefixSum;

    public NumArray(int[] nums) {
        prefixSum = new int[nums.length];
        //now calculate the prefixSum for the entire Array
        prefixSum[0] = nums[0];

        for(int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        //for left and right
        if(left == 0) {
            return prefixSum[right];
        }
        return prefixSum[right] - prefixSum[left - 1];

    }
}
