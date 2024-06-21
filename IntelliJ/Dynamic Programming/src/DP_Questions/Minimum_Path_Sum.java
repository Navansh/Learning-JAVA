package DP_Questions;

import java.util.Arrays;

public class Minimum_Path_Sum {
    public static void main(String[] args) {
//        Given a m x n grid filled with non-negative numbers, find a path from top left
//        to bottom right, which minimizes the sum of all numbers along its path.
        int[][] griderr = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(minPathSum(griderr));
    }

    public static int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return minPathHelper(dp,grid, grid.length - 1, grid[0].length - 1);
        //yahaan par length mein minus kardiya hence ab base case mein minus nahi karna padega
//        grid.length will give the row length, while grid[0].length will give col length
    }

    private static int minPathHelper(int[][] dp, int[][] grid, int m, int n) {
        if(m < 0 || n < 0) {
            //if any of x or y becomes negative
            return Integer.MAX_VALUE;
            //why, because ye case hamein nullify karna hai and
            //as return mein min wali value aage jaa rhi, so agar ham yahaan se
            //max value bhej rhe toh woh aage nhi jaayegi
        }

        if(m == 0 && n == 0) {
            return grid[0][0];
        }

        if(dp[m][n] != -1) {
            return dp[m][n];
        }

        int x = minPathHelper(dp,grid, m - 1, n);
        int y = minPathHelper(dp,grid, m, n - 1);

        dp[m][n] = Math.min(x,y) + grid[m][n];
        return Math.min(x,y) + grid[m][n];
    }

    public int minPathSumIterative(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if(i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if(j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }
}
