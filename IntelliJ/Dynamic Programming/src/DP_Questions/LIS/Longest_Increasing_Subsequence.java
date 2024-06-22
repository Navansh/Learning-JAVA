package DP_Questions.LIS;

import java.util.Arrays;

public class Longest_Increasing_Subsequence {
    public static void main(String[] args) {
        //https://leetcode.com/problems/longest-increasing-subsequence/submissions/1296428358/
    }

    public int lengthOfLIS(int[] nums) {
        //O(n^2) approach
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

    public int lengthOfLISOptimized(int[] nums) {
        //O(n logn) approach
        //for every ele we'll perform BS on dp array
        int[] dp = new int[nums.length];
        int ans = 0;
        //initially ans = 0 and NOT 1
        //as ans stores the next possible index of insertion
        //in dp array
        //toh dp array abhi khaali hai, toh ans should store 0

        for (int i = 0; i < nums.length; i++) {
            //do bs on dp array
            int lo = 0;
            int hi = ans;

            while (lo < hi) {
                //and not lo <= hi as hi is not included
                //in our search space, as hi has 0 as value
                //as that points to our (last index having a no + 1 ) index
                // initially and then moves accordingly during BS
                //so effective search space is [lo, hi - 1]
                int mid = lo + (hi - lo)/2;
                //now we want to find ceil of given ith index
                //ele in the dp array
                if(dp[mid] < nums[i]) {
                    lo = mid + 1;
                } else if(dp[mid] >= nums[i]) {
                    //we want the least bigger ele
                    hi = mid;
                }
            }
            //this BS just helps us find the position for insertion
            //of our nums[i] ele in the correct place in the dp array
            //so as to maintain the longest
            //increasing order subsequence

            dp[lo] = nums[i];
            //or we can even write : dp[hi] = nums[i];
            //as both of them are at same position
            if(lo == ans) {
                //the place we're inserting in dp array
                //is it the last empty index ( ele != 0 ), if yes
                //then increase ans by 1
                ans++;
            }
        }

        return ans;
    }


}
