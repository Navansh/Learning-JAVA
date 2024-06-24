package DP_Questions.Strings;

import java.util.Arrays;

public class Longest_Common_Subsequence {
    public static void main(String[] args) {
        //https://leetcode.com/problems/longest-common-subsequence/submissions/1297689106/
        String s1 = "bl";
        String s2 = "yby";
        System.out.println(longestCommonSubsequenceIterative(s1, s2));

    }

    public int longestCommonSubsequence(String text1, String text2) {
        //this is the top-down approach
        //maintain pointers for both text1 and text2
        int i = text1.length();
        int j = text2.length();

        int[][] dp = new int[i][j];
        //as we need indexes

        for(int[] dpx : dp) {
            Arrays.fill(dpx, - 1);
        }

        return LCSHelper(text1, i - 1, text2, j - 1, dp);
        //as index bhejni hai naa hamein last char ki
    }

    private int LCSHelper(String text1, int i, String text2, int j, int[][] dp) {

        if(i < 0 || j < 0) {
            //if i or j is 0, then char at 0th index is left
            //but if it goes negative, then there is nothing left to match
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if(text1.charAt(i) == text2.charAt(j)) {
            //reduce 1 from both of them
            int x = LCSHelper(text1, i - 1, text2, j - 1, dp);
            dp[i][j] = x + 1;
            return x + 1;
        } else {
            //they aren't equal so we got both x and y
            int x = LCSHelper(text1, i - 1, text2, j, dp);
            int y = LCSHelper(text1, i, text2, j - 1, dp);
            dp[i][j] = Math.max(x, y);
            return Math.max(x, y);
        }
    }

    public static int longestCommonSubsequenceIterative(String text1, String text2) {
        //this is the bottom-up approach
        int i = text1.length();
        int j = text2.length();

        int[][] dp = new int[i][j];
        //as we need indexes

        for (int k = 0; k < i; k++) {
            for (int l = 0; l < j; l++) {
                char chK = text1.charAt(k);
                char chL = text2.charAt(l);
                if(k == 0 || l == 0) {
                    if(chK == chL) {
                        dp[k][l] = 1;
                    } else {
                        if(k == 0 && l == 0) {
                            dp[k][l] = 0;
                        } else if (k == 0) {
                            dp[k][l] = dp[k][l - 1];
                        } else {
                            dp[k][l] = dp[k - 1][l];
                        }
                    }
                } else {
                    if(text1.charAt(k) == text2.charAt(l)) {
                        dp[k][l] = 1 + dp[k - 1][l - 1];
                    } else {
                        dp[k][l] = Math.max(dp[k - 1][l], dp[k][l - 1]);
                    }
                }
            }
        }

        return dp[i - 1][j - 1];

    }
}
