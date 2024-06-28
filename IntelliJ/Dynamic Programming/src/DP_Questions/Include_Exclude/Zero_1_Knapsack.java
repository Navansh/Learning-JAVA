package DP_Questions.Include_Exclude;

import java.util.Arrays;

public class Zero_1_Knapsack {
    public static void main(String[] args) {
        //https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1?itm_source=geeksforgeeks
    }

    static int knapSack(int W, int wt[], int val[], int n) {
        //w-> Knapsack capacity
        int[][] dp = new int[wt.length][W + 1];
        //as har length ke liye ki saari possibilities
        //consider karni padengi
        //so we make W + 1

        //as the no. of rows is just the index till which
        //we're talking about and the max it can go is weight.length - 1,
        //so we use weight.length as rows

        for(int[] dpx : dp) {
            Arrays.fill(dpx, - 1);
        }

        return knapsackHelper(dp, W, wt, val, wt.length - 1);
        //the last one is the ladt index, till which we need
        //to find
        //the start point is 0 for all
    }

    private static int knapsackHelper(int[][] dp, int w, int[] wt, int[] val, int i) {
        if(i < 0 || w == 0) {
            //if any of these conditions become true
            //then there is nothing we can pick
            return 0;
            //if val array has something negative then return
            //Integer.MIN_VALUE here, as woh case nhi hai
            //so, we return 0
            //as that will be nullified by our Math.max(x,y)
        }

        if(dp[i][w] != -1) {
            return dp[i][w];
        }

        int x = knapsackHelper(dp, w, wt, val, i - 1);
        //this is call for exclude
        //meaning don't pick this ele

        int y = 0;
        if(w >= wt[i]) {
            //this will ensure that we have enough weight
            //still available to pick up this call
            //and hence this will ensure the remaining "w"
            //does not go negative
            y = knapsackHelper(dp, w - wt[i], wt, val, i - 1) + val[i];
            //this is the cal for include
        }

        dp[i][w] = Math.max(x, y);
        return Math.max(x, y);
    }

    static int knapSackIterative(int W, int wt[], int val[], int n) {
        int[][] dp = new int[wt.length][W + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(j == 0) {
                    //meaning the bag capacity is 0
                    dp[i][j] = 0;
                } else if( i == 0) {
                    if(j - wt[i] >= 0) {
                        dp[i][j] = val[i];
                    }
                } else {
                    dp[i][j] = dp[i - 1][j];
                    //not picked condition, assuming we don't have enough W
                    //hence that part (dp[i - 1][j - wt[i]]) of the recurrence relation is nullified
                    //as picking that weight is not possible

                    //to pick any weight, this condition must be true
                    if(j - wt[i] >= 0) {
                        //means we have enough capacity in knapsack to pick the ith weight
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[i]] + val[i]) ;
                    }
                }
            }
        }

        return dp[wt.length - 1][W];
    }
}