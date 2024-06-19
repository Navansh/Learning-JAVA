package HashMap_Questions.Anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class All_Anagrams_in_a_List {
    public static void main(String[] args) {

    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        if(p.length() > s.length()) {
            //no anagrams in this case
            return ans;
        }

        //create the hashmap for p
        HashMap<Character, Integer> hxP = new HashMap<>();
        for (int i = 0; i < p.length(); i++) { //O(p)
            char ch = p.charAt(i);
            hxP.put(ch, hxP.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> hxS = new HashMap<>();
        int matchCount = 0;

        //creating the 1st window, in which we'll acquire all chars
        for (int i = 0; i < p.length(); i++) { //o(p)
            //as we've already removed the case where p's len > s's len
            //so atleast s has enough chars as p
            //so we add s's chars upto p's length times
            //so say p's len is 3 so we add 3 chars from s
            hxS.put(s.charAt(i), hxS.getOrDefault(s.charAt(i), 0) + 1);

            //now check if the character you just acquired is useful or not
            if(hxS.get(s.charAt(i)) <= hxP.getOrDefault(s.charAt(i), 0)) {
                //if the char is not present in hxP then it will return 0
                //then this is a useful char
                matchCount++;
            }
        }

        if(matchCount == p.length()) {
            //then we've found one of the anagram
            ans.add(0);
        }

        //now we'l start the generic sliding
        int startP = 0;
        //this is the first character that will be released
        int endP = p.length();
        //this is the first char that will be acquired

        while (endP < s.length()) { //O(s.length - p.length )
            //acquire the endP index
            hxS.put(s.charAt(endP), hxS.getOrDefault(s.charAt(endP), 0) + 1);

            //now check if the character you just acquired is useful or not
            if(hxS.get(s.charAt(endP)) <= hxP.getOrDefault(s.charAt(endP), 0)) {
                //if the char is not present in hxP then it will return 0
                //then this is a useful char
                matchCount++;
            }

            //now release the start index
            hxS.put(s.charAt(startP), hxS.get(s.charAt(startP)) - 1);
            //no null error here, as pehle acquire kiya hoga start point
            //waala char

            if(hxS.get(s.charAt(startP)) < hxP.getOrDefault(s.charAt(startP), 0)) {
                //no equal : as agar release karne ke baad bhi its freq is equal to the req
                //then we still have all the req chars
                //so no loss
                //matlab pehle thaa ab aur kam hogya
                //as upar waale step mein hamne -1 kardiya
                //ya phir pehle equal thaa and ab kam ho gya
                matchCount--;
            }

            //we can also do release first and acquire later

            //prepare for next window
            startP++;
            endP++;

            if(matchCount == p.length()) {
                ans.add(startP);
            }
        }

        return ans;
    }
}
