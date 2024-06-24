package DP_Questions.Strings;

import java.util.Arrays;

public class Edit_Distance {
    public static void main(String[] args) {
        //https://leetcode.com/problems/edit-distance/
    }

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];

        for (int[] dpx : dp) {
            Arrays.fill(dpx, - 1);
        }

        return minDistanceHelper(word1, word1.length() - 1, word2, word2.length() - 1, dp);
    }

    private int minDistanceHelper(String word1, int i, String word2, int j, int[][] dp) {
        if(i < 0 && j < 0) {
            return 0;
        }

        if(i < 0 && j >= 0) {
            //means there is nothing left to solve in i (string 1), but there
            //is some chars left in j
            return j + 1;
            //these many operation are atleast needed
            //and that operation is adding chars in s1
        }

        if(i >= 0 && j < 0) {
            //meaning there are chars still left in string 1, but
            //s2 has been completely matched, so delete all the remaining chars in s1
            return i + 1;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if(word1.charAt(i) == word2.charAt(j)) {
            //no need to do any operation, just call further
            int x = minDistanceHelper(word1, i - 1, word2, j - 1, dp);
            dp[i][j] = x;
            return x;
        } else {
            //do three calls, add, replace, delete
            //add
            int x = minDistanceHelper(word1, i, word2, j - 1, dp);
            //replace
            int y = minDistanceHelper(word1, i - 1, word2, j - 1, dp);
            //delete
            int z = minDistanceHelper(word1, i - 1, word2, j, dp);

            dp[i][j] = Math.min(Math.min(x + 1, y + 1), z + 1);
            return Math.min(Math.min(x + 1, y + 1), z + 1);
            //can also do Math.min(Math.min(x, y), z) + 1;
        }
    }
}
