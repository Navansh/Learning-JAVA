package DP_Questions.Strings;

import java.util.Arrays;

public class LCS_of_3_strings {
    public static void main(String[] args) {
        //https://www.geeksforgeeks.org/problems/lcs-of-three-strings0028/1?itm_source=geeksforgeeks
    }

    int LCSof3(String A, String B, String C, int n1, int n2, int n3) {
        int[][][] dp = new int[A.length()][B.length()][C.length()];

        for(int[][] dpx : dp) {
            for(int[] dpy : dpx) {
                Arrays.fill(dpy, - 1);
            }
        }

        return LCSHelper(A, B, C, A.length() - 1, B.length() - 1, C.length() - 1, dp);
    }

    private int LCSHelper(String a, String b, String c, int i, int j, int k, int[][][] dp) {
        if(i < 0 || j < 0 || k < 0) {
            return 0;
        }

        if(dp[i][j][k] != -1) {
            return dp[i][j][k];
        }

        if(a.charAt(i) == b.charAt(j) && b.charAt(j) == c.charAt(k)) {
            //meaning all of them are equal
            int x = LCSHelper(a, b, c, i - 1, j - 1, k - 1, dp);
            dp[i][j][k] = x + 1;
            return x + 1;
        } else {
            int x = LCSHelper(a, b, c, i - 1, j, k, dp);
            int y = LCSHelper(a, b, c, i, j - 1, k, dp);
            int z = LCSHelper(a, b, c, i, j, k - 1, dp);

            dp[i][j][k] = Math.max(Math.max(x,y), z);
            return Math.max(Math.max(x,y), z);
        }
    }
}
