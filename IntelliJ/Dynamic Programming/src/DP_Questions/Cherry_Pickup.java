package DP_Questions;

import java.util.Arrays;

public class Cherry_Pickup {
    public static void main(String[] args) {
        int[][] grid = {
                {0,1,-1},
                {1,0,-1},
                {1,1,1}
        };

        System.out.println(cherryPickupSingle(grid));
    }

    public int cherryPickup(int[][] grid) {
        int[][][] dp = new int[grid.length][grid[0].length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        int row1 = 0;
        int col1 = 0;
        int row2 = 0;
        int ans = cherryHelper(dp, grid, row1, col1, row2);
        if(ans < 0) {
            return 0;
            //[[1,1,-1],[1,-1,1],[-1,1,1]] , in this case it will return Integer.MIN_VALUE
            //this is due to the barrier condition
        }
        return ans;
    }

    private int cherryHelper(int[][][] dp, int[][] grid, int row1, int col1, int row2) {
        int col2 = row1 + col1 - row2;

        //this is the base case1
        if(row1 >= grid.length || col1 >= grid.length || row2 >= grid.length || col2 >= grid.length ) {
            return Integer.MIN_VALUE;
            //as we are taking this so that we don't consider this in the final returned ans
            //as that will take max

        }

        //this is to skip barrier
        if(grid[row1][col1] == -1 || grid[row2][col2] == -1) {
            return Integer.MIN_VALUE;
            //again as in the final ans, we are taking max, so this would be skipped
            //in that as its returing min value
        }

        //base case : when they both finally reach the destination
        //yes they both will reach the destination after same number of steps
        //because it is only allowed to move right or down

        if(row1 == grid.length - 1 && col1 == grid[0].length - 1 && row2 == grid.length - 1 && col2 == grid[0].length - 1) {
            return grid[row1][col1];
        }

        //dp optimization if available
        if(dp[row1][col1][row2] != -1) {
            return dp[row1][col1][row2];
        }

        //now make them move RR, RD, DR, DD
        //why because these are all the possible combination in which 2 ppl can move
        //across the matrix

        int temp1 = cherryHelper(dp, grid, row1, col1 + 1, row2);
        int temp2 = cherryHelper(dp, grid, row1, col1 + 1, row2 + 1);
        int temp3 = cherryHelper(dp, grid, row1 + 1, col1, row2);
        int temp4 = cherryHelper(dp, grid, row1 + 1, col1, row2 + 1);


        int ans1 = Math.max(temp1, temp2);
        ans1 = Math.max(ans1, temp3);
        ans1 = Math.max(ans1, temp4);

        int contri = 0;

        //there are 2 cases here :
        //if they both land on a same tile which has a cherry, then only one will be
        //able to claim it

        if(row1 == row2 && col1 == col2) {
            contri = grid[row1][col1];
        } else {
            contri = grid[row1][col1] + grid[row2][col2];
        }

        //set the DP
        dp[row1][col1][row2] = ans1 + contri;
        return ans1 + contri;

    }

    public static int cherryPickupSingle(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        int[][] dp2 = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(dp2[i], -1);
        }
        int row1 = 0;
        int col1 = 0;
        int ans1 = cherryHelperSingle(dp, grid, row1, col1);
        int ans2 = cherryHelperSingle(dp2,grid,row1,col1);
        if(ans1 < 0 || ans2 < 0) {
            return 0;
            //[[1,1,-1],[1,-1,1],[-1,1,1]] , in this case it will return Integer.MIN_VALUE
            //this is due to the barrier condition
        }
        return ans1 + ans2;
    }

    private static int cherryHelperSingle(int[][] dp, int[][] grid, int row1, int col1) {
        //this is the base case1
        if(row1 >= grid.length || col1 >= grid.length) {
            return Integer.MIN_VALUE;
            //as we are taking this so that we don't consider this in the final returned ans
            //as that will take max

        }

        //this is to skip barrier
        if(grid[row1][col1] == -1) {
            return Integer.MIN_VALUE;
            //again as in the final ans, we are taking max, so this would be skipped
            //in that as its returing min value
        }

        //base case : when they both finally reach the destination
        //yes they both will reach the destination after same number of steps
        //because it is only allowed to move right or down

        if(row1 == grid.length - 1 && col1 == grid[0].length - 1 ) {
            return grid[row1][col1];
        }

        //dp optimization if available
        if(dp[row1][col1] != -1) {
            return dp[row1][col1];
        }

        //now make them move RR, RD, DR, DD
        //why because these are all the possible combination in which 2 ppl can move
        //across the matrix

        int temp1 = cherryHelperSingle(dp, grid, row1, col1 + 1);
        int temp2 = cherryHelperSingle(dp, grid, row1 + 1, col1);

        int ans1 = Math.max(temp1, temp2);
        int contri = 0;

        //there are 2 cases here :
        //if they both land on a same tile which has a cherry, then only one will be
        //able to claim it

        contri = grid[row1][col1];

        //set the DP
        dp[row1][col1] = ans1 + contri;
        grid[row1][col1] = 0;
        return ans1 + contri;

    }
}
