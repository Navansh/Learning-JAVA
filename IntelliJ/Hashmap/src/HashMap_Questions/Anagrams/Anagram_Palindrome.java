package HashMap_Questions.Anagrams;

import java.util.HashMap;

public class Anagram_Palindrome {
    public static void main(String[] args) {
        //https://www.geeksforgeeks.org/problems/anagram-palindrome4720/1
    }

    int isPossible (String S) {
        int[] arr = new int[26];

        for (int i = 0; i < S.length(); i++) {
            int index = S.charAt(i) - 'a';
            arr[index]++;
        }

        //now after this is done
        boolean flag = false;
        for(int m : arr) {
            if(m%2 ==0) {
                continue;
            } else if(!flag) {
                //else mein aaya hai toh odd hi hoga
                //toh check if it is his 1st time or not
                //if first time then allow one time
                flag = true;
            } else {
                return 0;
            }
        }

        return 1;
    }
}
