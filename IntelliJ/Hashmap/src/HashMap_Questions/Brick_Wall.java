package HashMap_Questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Brick_Wall {
    public static void main(String[] args) {
        List<Integer> ls1 = new ArrayList<>();
        //https://leetcode.com/problems/brick-wall/submissions/1286057252/

    }

    public static int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> hx = new HashMap<>();
        //it essentailly stores
        //vertical line VS no of breaks in it
        int n = wall.size();
        //this is the no of rows in the wall

        int ans = 0;
        for(List<Integer> ls : wall) {
            int prefixSum = 0;
            for (int i = 0; i < ls.size() - 1; i++) {
                //so we'll not go through last element
                //because adding that would give us last line
                //which we want to avoid
                //as per the question
                prefixSum += ls.get(i);
                hx.put(prefixSum, hx.getOrDefault(prefixSum, 0) + 1);
                //update ans here only
                ans = Math.max(ans, hx.get(prefixSum));
                //this gets the max freq of no of spaces in a
                //or max no of spaces in a line in this wall
                //particular line, it doesn't store that
                //index of the line
            }
        }

        return n - ans;
    }
}
