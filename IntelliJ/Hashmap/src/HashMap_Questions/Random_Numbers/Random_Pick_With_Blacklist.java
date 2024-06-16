package HashMap_Questions.Random_Numbers;

import java.util.HashMap;
import java.util.Random;

public class Random_Pick_With_Blacklist {
    public static void main(String[] args) {
        //https://leetcode.com/problems/random-pick-with-blacklist/description/

    }

    class Solution {
        HashMap<Integer, Integer> hx;
        //this represents the number and its mapping
        Random r;
        int Valid;
        public Solution(int n, int[] blacklist) {
            hx = new HashMap<>();
            r = new Random();

            //we need to generate random from 0 to n - 1
            //so put the blacklisted numbers in the HashMap
            for(int bl : blacklist) {
                hx.put(bl, -1);
            }
            //we need to do this because the lower loop only checks
            //for bl that is less than validCountNum, and then maps it
            //so for that we need mapping of every blacklisted number
            //so that while mapping a blacklisted to another number
            //in the range of [n-m + 1, n - 1], we don't map it
            //to a blacklisted number

            int validNumCount = n - blacklist.length;
            Valid = validNumCount;
            n--;
            //because n is non included, so our inclusive range is
            //[0, n- 1]
            //now we map the numbers
            for(int bl : blacklist) {
                if(bl < validNumCount) {
                    //meaning it falls in the range of our valid
                    //count numbers, if they are bigger then
                    //that, then we're already ignoring them
                    //while calculating the random int

                    while (hx.containsKey(n)) {
                        n--;
                    }
                    //this will make us find a number that is not
                    //blacklisted from the remaining numbers
                    //from n - m + 1 to n - 1
                    hx.put(bl, n);
                    n--;
                }
            }
        }

        public int pick() {
            int picked = r.nextInt(Valid);
            if(hx.containsKey(picked)) {
                //then return the mapped value, because the number we
                //chose was blacklisted
                //so return the non blacklisted value that we mapped to it
                return hx.get(picked);
            }

            return picked;
        }
    }

}
