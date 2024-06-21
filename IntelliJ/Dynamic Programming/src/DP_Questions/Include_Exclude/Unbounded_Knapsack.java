package DP_Questions.Include_Exclude;

import java.util.Arrays;

public class Unbounded_Knapsack {
    public static void main(String[] args) {
        //https://www.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1?itm_source=geeksforgeeks
    }

    static int knapSack(int N, int W, int val[], int wt[]) {
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
        //the last variable is the last index, till which we need
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
            y = knapsackHelper(dp, w - wt[i], wt, val, i) + val[i];
            //the only difference is that i won't reduce
            //even after including
            //this is the cal for include
        }

        dp[i][w] = Math.max(x, y);
        return Math.max(x, y);
    }
}
