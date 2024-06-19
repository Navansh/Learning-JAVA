package HashMap_Questions.Anagrams;

import java.util.HashMap;

public class Minimum_Window_Substring {
    public static void main(String[] args) {

    }

    public String minWindow(String s, String t) {
        //s is the main string
        //t is the one that we need to find for
        char[] sArr = s.toCharArray(); //O(s)
        char[] tArr = t.toCharArray(); //O(t)

        if(t.length() > s.length()) {
            return "";
        }

        HashMap<Character, Integer> hxS = new HashMap<>();
        HashMap<Character, Integer> hxT = new HashMap<>();

        int matchCount = 0;

        //firstly create the hxT map
        for (int i = 0; i < t.length(); i++) {
            hxT.put(t.charAt(i), hxT.getOrDefault(t.charAt(i), 0) + 1);
        }

        int ansLen = Integer.MAX_VALUE;
        int startPoint = 0;
        int endPoint = 0;
        //as endPoint ka idea nhi hai as abhi
        //tak ek bhi valid window mili nhi hai

        int ansStartIndex = -1;
        int ansEndIndex = -1;

        while (endPoint < s.length()) { //O(s + s) either you acquire a char or release a char
            //we'll do this as long as we've something to acquire
            if(matchCount == t.length()) {
                //then this is a valid substring
                if(endPoint - startPoint < ansLen) {
                    //sp this is a valid substring and has
                    //len less than current ansLen
                    //then update
                    ansLen = endPoint - startPoint;
                    ansStartIndex = startPoint;
                    ansEndIndex = endPoint - 1;
                    //as endPoint denotes the next char
                    //to be acquired
                    //toh abhi apan jis substring par work
                    //kar rahe, usmein endPoint index par jo
                    //char hai woh included hi nhi hai
                }
                //now you need to start releasing chars now
                //so that we can shorten it further

                hxS.put(s.charAt(startPoint), hxS.get(s.charAt(startPoint)) - 1);
                if(hxS.get(s.charAt(startPoint)) < hxT.getOrDefault(s.charAt(startPoint), 0)) {
                    //meaning we removed a useful char so
                    //now this useful char's freq is decreased by 1
                    //then as to what is required to have a valid substring
                    matchCount--;
                }
                //as this was the case when the substring was valid
                //so we need to shorten the length, until the substring
                //becomes invalid
                startPoint++;
            } else {
                //this is not a valid endpoint and you need
                //to keep acquiring now, until you get a valid substring
                //so startPoint will be fixed and endPoint will move
                hxS.put(s.charAt(endPoint), hxS.getOrDefault(s.charAt(endPoint), 0) + 1);
                if(hxS.get(s.charAt(endPoint)) <= hxT.getOrDefault(s.charAt(endPoint), 0)) {
                    matchCount++;
                }

                endPoint++;
            }
        }

        //now we handle one edge case
        while (matchCount == t.length()) {
            if(endPoint - startPoint < ansLen) {
                //sp this is a valid substring and has
                //len less than current ansLen
                //then update
                ansLen = endPoint - startPoint;
                ansStartIndex = startPoint;
                ansEndIndex = endPoint - 1;
            }
            //now you need to start releasing chars now
            //so that we can shorten it further

            hxS.put(s.charAt(startPoint), hxS.get(s.charAt(startPoint)) - 1);
            if(hxS.get(s.charAt(startPoint)) < hxT.getOrDefault(s.charAt(startPoint), 0)) {
                //meaning we removed a useful char so
                matchCount--;
            }
            //as this was the case when the substring was valid
            //so we need to shorten the length, until the substring
            //becomes invalid
            startPoint++;
        }

        if(ansLen == Integer.MAX_VALUE) {
            //meaning you never a got a substring that has
            //all the chars as of t
            return "";
        }

        //now form the string
        return s.substring(ansStartIndex, ansEndIndex + 1);
        //as last one is exclusive
    }
}
