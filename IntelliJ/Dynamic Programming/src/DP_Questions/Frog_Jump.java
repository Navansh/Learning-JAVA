package DP_Questions;

import java.text.CharacterIterator;
import java.util.HashMap;
import java.util.HashSet;

public class Frog_Jump {
    public static void main(String[] args) {
       //https://leetcode.com/problems/frog-jump/
    }

    public boolean canCross(int[] stones) {
        HashMap<Integer, HashSet<Integer>> hx = new HashMap<>();
        //when we want to store repeated values in hashmap
        //we use the combination of Hashmap and hashset
        //or hashmap and arraylist

        //this store the place of stones ki woh kis kis number par hain
        //vs
        //uss stone par kitne jump ke saath pahucha jaa sakta hai

        //in the end, agar last stone ka hashset agar empty nhi
        //hua toh it means it ham uss stone tak kisi naa kisi
        //way mein toh pahuch sakte hai

        for (int i = 0; i < stones.length; i++) {
            hx.put(stones[i], new HashSet<>());
        }

        //as given the ques, 0 se sirg 1 ka jump allowed hai
        HashSet temp = hx.get(stones[0]);
        temp.add(1);

        for (int i = 0; i < stones.length; i++) {
            int stone = stones[i];
            //now iss stone ke corresponding kitne ka jump le sakte hai
            for(int jump : hx.get(stone)) {
                //now using this value, ham next stones tak pahuch sakte
                //hai, now check wahaan par ek valid stone hai bhi ki nhi
                int validStone = stone + jump;
                if(validStone == stones[stones.length - 1]) return true;

                if(hx.containsKey(validStone)) {
                    if((jump - 1) > 0) hx.get(validStone).add(jump - 1);
                    hx.get(validStone).add(jump);
                    hx.get(validStone).add(jump + 1);
                }

                //now check if all these 3 exists

            }
        }


        return false;

    }

}
