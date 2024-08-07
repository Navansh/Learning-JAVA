package DP_Questions.Include_Exclude;

import java.util.Arrays;

public class Filling_Bookcase_Shelves {
    public static void main(String[] args) {
        //https://leetcode.com/problems/filling-bookcase-shelves/submissions/1340987049/?envType=daily-question&envId=2024-07-31
    }

    public int minHeightShelves(int[][] books, int shelfWidth) {
        //include exclude problem DP
        //1000 books

        //choosing to either include a book
        //in a shelf or put exclude it and put it in the
        //next shelf
        int index = 0;
        int remaining_width = shelfWidth;
        int maxHeight = 0;
        int[][] dp = new int[1001][1001];

        for(int[] dpx : dp) {
            Arrays.fill(dpx, -1);
        }
        int ans = solve(index, remaining_width, books, shelfWidth, maxHeight, dp);
        return ans;
    }

    private int solve(int index, int remainingWidth, int[][] books, int shelfWidth, int maxHeight, int[][] dp) {
        if(index >= books.length) {
            return maxHeight;
            //abhi tak ka
        }

        if(dp[index][remainingWidth] != -1) {
            return dp[index][remainingWidth];
        }
        int book_width = books[index][0];
        int book_height = books[index][1];

        int include = Integer.MAX_VALUE;
        int exclude = Integer.MAX_VALUE;

        if(book_width <= remainingWidth) {
            //then we can keep it here
            include = solve(index + 1, remainingWidth - book_width, books, shelfWidth, Math.max(maxHeight, book_height), dp);
        }
        //then only its possible to include it
        //otherwise we'll skip it
        //or we can event skip it even if it fits in the shelf
        //and then put in next shelf

        exclude = maxHeight + solve(index + 1, shelfWidth - book_width, books, shelfWidth, book_height, dp);
        //kyunki hamein overall height nikalna hai

        dp[index][remainingWidth] = Math.min(include, exclude);

        return Math.min(include, exclude);
    }
}
