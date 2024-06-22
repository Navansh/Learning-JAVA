package DP_Questions;

import java.util.Arrays;

public class Longest_Increasing_Subsequence {
    public static void main(String[] args) {

    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int max = 1;
        //min ans could be just 1, that is the ele itself waala subsequence
        for (int i = 1; i < nums.length; i++) {
            //for ith index, check all the ele before i th index

            for (int j = i - 1; j >= 0; j--) {
                if(nums[i] > nums[j]) {
                    //then this is increasing
                    int tempAns = dp[j] + 1;
                    dp[i] = Math.max(dp[i], tempAns);
                }
            }

            //if we have checked all the j's then we have
            //the final ans for ith index
            //so keep updating our final ans
            max = Math.max(dp[i], max);
        }

        return max;
    }
}
