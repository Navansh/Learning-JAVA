package DP_Questions.Include_Exclude;

import java.util.Arrays;

public class Max_Subsequence_Sum {
    public static void main(String[] args) {
        //https://www.geeksforgeeks.org/problems/stickler-theif-1587115621/1?itm_source=geeksforgeeks
    }

    public int FindMaxSum(int[] arr, int n) {
        long[] dp = new long[n];
        //as our indexes are anyways from [0, n - 1]
        Arrays.fill(dp, -1);
        return findMaxSumHelper(arr,dp, n - 1);
    }

    private int findMaxSumHelper(int[] arr,long[] dp, int i) {
        if(i < 0) {
            //if(i == 0) {
            //won't work as then also we have the option
            //to choose the 0th index ele or to reject
            //it and choose nothing
            //}
            //i is negative means there is nothing to choose
            //from, then the maxSubsSum is 0
            return 0;
        }
        //here we'll take i as endPoint
        //for our further calls
        //and starting point is same for all that is -> 0

        //check for dp
        if(dp[i] != -1) {
            return (int) dp[i];
        }

        //case1 : exclude the nth index
        long ans1 = findMaxSumHelper(arr, dp, i - 1);
        //case 2 : include the nth index and exclude the
        //adjacent index
        long ans2 = findMaxSumHelper(arr,dp, i - 2) + arr[i];

        dp[i] = Math.max(ans1, ans2);
        return (int) Math.max(ans1, ans2);
    }
}
