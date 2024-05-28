package Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class LC_1255_Max_Score_words_formed_by_letters {
    public static void main(String[] args) {

    }
    public int maxScore = Integer.MIN_VALUE;
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] arr = new int[26];
        //we'll use the index as char index, and its value as the freq
        //initially the complete array is initialized as 0
        //using this, we can directly get the score of each letter using the
        //score array


        int n = words.length;

        for (char ch : letters) {
            arr[ch - 'a']++;
        }

        solve(0, score, words, 0, arr);
        //index, score, words, currentScore, freq
        return maxScore;

    }

    private void solve(int i, int[] score, String[] words, int currentScore, int[] arr) {
        maxScore = Math.max(maxScore, currentScore);
        if(i >= words.length) {
            return;
        }

        //can we even take this word[i]
        //form the word
        int[] tempfreq =  Arrays.copyOf(arr, arr.length);

        //at max 26 size, hence O(26) operation
        //is we just equate them then tempfreq will act as another variable pointing
        //to the same array in the heap memory

        int accept = 0;
        int tempScore = 0;
        for (int j = 0; j < words[i].length(); j++) { //O(L)
            String word = words[i];
            if(tempfreq[word.charAt(j) - 'a'] > 0) {
                tempfreq[word.charAt(j) - 'a']--;
                tempScore += score[word.charAt(j) - 'a'];
            } else {
                break;
            }
            accept++;
        }

        if(accept == words[i].length()) {
            //if only all the letters are accepted then we are able to take the word
            //then we were able to take this word
            solve(i + 1, score, words, currentScore + tempScore, tempfreq);
        }

        //or don't take
        solve(i + 1, score, words, currentScore, arr);
    }
}
