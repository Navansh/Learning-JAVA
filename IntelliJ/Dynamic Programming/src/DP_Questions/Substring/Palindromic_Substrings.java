package DP_Questions.Substring;

public class Palindromic_Substrings {
    public static void main(String[] args) {
       //https://leetcode.com/problems/palindromic-substrings/description/
    }

    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        //initially all cells are filled with false
        int count = 0;

        //now as we want to do diagonal traversal, we use the
        //"gap" waala loop

        for (int gap = 0; gap < s.length(); gap++) {
            //gap = 0 represents the middle most diagonal
            //and so on...
            int i = 0;
            int j = gap;
            //this is the start cell for each diagonal
            //this moves till j is out of bounds
            while (j < s.length()) {
                if(gap == 0) {
                    dp[i][j] = true;
                    count++;
                    //as these are all palindromic
                } else if(gap == 1) {
                    //in this there is no mid value
                    //we just check 2 chars or we can say
                    //our gap is 1

                    //so we've to handle this seperately
                    //and in this if the chars are equal then it is
                    //a palindrome
                    if(s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                        count++;
                    }
                } else {
                    //check if both the chars are equal
                    if(s.charAt(i) == s.charAt(j)) {
                        //then check if the chars from
                        //(i + 1 , j - 1) form a substring
                        dp[i][j] = dp[i + 1][j - 1];
                        //if dp[i + 1][j - 1] is a palindrome
                        //this will give true else false
                        if(dp[i][j] == true) {
                            //if it then becomes true, then
                            count++;
                        }
                    } else {
                        dp[i][j] = false;
                    }
                }
                i++;
                j++;
            }
        }

        return count;

    }


}
