package DP_Questions.Substring;

public class Longest_Common_Substring {
    public static void main(String[] args) {
        //https://www.geeksforgeeks.org/problems/longest-common-substring1452/1
    }

    int longestCommonSubstr(String S1, String S2, int n, int m){
        int[][] dp = new int[S1.length()][S2.length()];
        int ans = 0;
        //this represents the maxLength of the substring

        for (int i = 0; i < S1.length(); i++) {
            for (int j = 0; j < S2.length(); j++) {
                boolean check = S1.charAt(i) == S2.charAt(j);
                if(i == 0 || j == 0) {
                    dp[i][j] = check ? 1 : 0;
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    if(check) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = 0;
                    }
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }

        return ans;
    }

    int longestCommonSubstrRecursive(String S1, String S2, int n, int m){
        return LCSHelper(S1, S2, S1.length() - 1, S2.length() - 1);
        //TODO : Recursive version of this code
    }

    private int LCSHelper(String s1, String s2, int i, int j) {
        if(i == 0 || j == 0) {
            return 0;
        }

        //this is just placeholder
        return -1;
    }
}
