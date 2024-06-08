package BiWeekly_Contest.Contest_131;

import java.util.HashMap;

public class B {
    public static void main(String[] args) {

    }

    public static int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        HashMap<Integer, Integer> hx = new HashMap<>();
        int occurance = 1;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == x) {
                hx.put(occurance, i);
                occurance++;
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            ans[i] = hx.getOrDefault(queries[i], -1);
        }

        return ans;
    }
}
