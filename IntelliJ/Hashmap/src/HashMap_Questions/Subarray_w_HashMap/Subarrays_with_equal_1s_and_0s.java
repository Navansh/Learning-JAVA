package HashMap_Questions.Subarray_w_HashMap;

import java.util.HashMap;

public class Subarrays_with_equal_1s_and_0s {
    public static void main(String[] args) {

    }

    static int countSubarrWithEqualZeroAndOne(int arr[], int n) {
        //create HashMap
        HashMap<Integer ,Integer> hx = new HashMap<>();

        int ans = 0;
        int prefixCZero = 0;
        //denotes prefixCount of Zero
        int prefixCOne = 0;
        //denotes prefixCount of One


        hx.put(0 ,1);
        //if the diff comes out to be zero, then one valid start
        //point is from the 0th index till ith index

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                prefixCZero++;

            }
            if(arr[i] == 1) {
                prefixCOne++;
            }

            //check if the map contains the difference
            //considering i as the end point
            int diff = prefixCZero - prefixCOne;

            if(hx.containsKey(diff)) {
                ans += hx.getOrDefault(diff, 0);
            }

            //now put this diff for future use to be used as
            //a starting point
            hx.put(diff, hx.getOrDefault(diff, 0) + 1);
        }

        return ans;
    }
}
