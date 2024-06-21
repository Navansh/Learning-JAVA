package DP_Questions;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
//        Given the two integers m and n,
//        return the number of possible unique paths that the robot can take to reach
//        the bottom-right corner. ( which is (m - 1, n - 1) )
        System.out.println(uniquePaths(3,7));
        System.out.println(uniquePathsDP(3,7));
    }

    public static int uniquePaths(int m, int n) {
        //we have optimal substructure in this problem hence we can use recursion
        //we also have overlapping subproblem, so we can optimize it with DP
        if(m - 1 == 0 || n - 1 == 0) {
            return 1;
            //as path toh ek hi hai, that is go right
            //as path toh ek hi hai that is go down
        }

        //(m,n) are the end points to reach and 0,0 is the starting point for every case
        int rightAns = uniquePaths(m, n-1);
        int downAns = uniquePaths(m-1, n);

        return rightAns + downAns;
    }

    public static int uniquePathsDP(int m, int n) {
        int[][] dp = new int[m][n];
        //m, n as we are going to use only till m - 1, n - 1
        //as given in the ques

        for(int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return pathHelperDp(dp, m,n);

    }

    private static int pathHelperDp(int[][] dp, int m, int n) {
        //m - 1, and n - 1 are the endpoints, start pt sabke liye 0,0 hai
        if(m - 1 == 0 || n - 1 == 0) {
            return 1;

            //m-1 and n - 1 par isliye karrhe cz hamne initially m and n pass karte waqt
            //usse m-1 and n - 1 nhi kiyaa thaa
        }

        if(dp[m-1][n-1] != -1) {
            return dp[m-1][n-1];
        }

        int rightAns = pathHelperDp(dp,m, n-1);
        int downAns = pathHelperDp(dp,m-1, n);

        dp[m-1][n-1] = rightAns + downAns;

        return rightAns + downAns;
    }

    public int uniquePathsIterative(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0|| j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public static int uniquePathsWithBlockade(int[][] dp, int m, int n) {
        //this is a special case, in which a blockade matrix is given
        //in which there are 0 and 1 values assigned to cells, denoting that
        //whether they're blocked or available to travel

        int[][] blockade = new int[m][n];
        //this will be made in the orginal function, and be passed as a prop here
        //because we don't have to create this

        if(m - 1 < 0 || n - 1 < 0) {
            return 0;
        }

        if(m - 1 == 0 && n - 1 == 0) {
            //as there is no blockade on 0,0
            return 1;
        }

        if(blockade[m-1][n-1] == 0) {
            return 0;
            //as this way is not possible
        }

        //rest all same code
        if(dp[m-1][n-1] != -1) {
            return dp[m-1][n-1];
        }

        int rightAns = uniquePathsWithBlockade(dp,m, n-1);
        int downAns = uniquePathsWithBlockade(dp,m-1, n);

        dp[m-1][n-1] = rightAns + downAns;

        return rightAns + downAns;

    }
}
