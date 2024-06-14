package HashMap_Questions.Subarray_w_HashMap;

import java.util.HashMap;

public class Same_Differences {
    public static void main(String[] args) {

    }

    public static int countPairs(int[] arr) {
        HashMap<Integer, Integer> hx = new HashMap<>();
        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            int diff = arr[i] - i;
            ans += hx.getOrDefault(diff, 0);
            //as the valid i we need is arr[i] - i, which
            //is equal to arr[j] - j, hence we search for arr[j] - j
            //if that's there means somewhere in the prev indexes
            //this was equal, which can become our i

            //if not, then we put
            hx.put(diff, hx.getOrDefault(diff, 0) + 1);
        }

        return ans;
    }
}
