package DP_Questions.Strings;

public class Longest_Palindromic_Subsequence {
    public static void main(String[] args) {
        //https://leetcode.com/problems/longest-palindromic-subsequence/
    }

    public int longestPalindromeSubseq(String s) {
        StringBuilder s2 = new StringBuilder();
        s2.append(s);
        s2.reverse();

        String text1 = s;
        String text2 = s2.toString();

        //now apply LCS on text1 and text2
        //here we are doing iteratively
        //we can also di recursively
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
