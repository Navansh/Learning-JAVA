package Array_Questions.SubArrays;

import java.util.HashMap;

public class Subarrays_Sums_Divisible_by_K {
    public static void main(String[] args) {

    }

    public int subarraysDivByK(int[] nums, int k) {
        int ans = 0;

        HashMap<Integer, Integer> remFreq = new HashMap<>();

        remFreq.put(0,1);
        //now initially put 0, 1 in HashMap as sum is 0 so rem is 0
        //this will help us capture subarrays that start from 0th index
        int sum = 0;
        int rem = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            rem = sum % k;
            if(rem < 0) {
                rem += k;
            }

            //now check if this rem exists already in the HashMap
            if(remFreq.containsKey(rem)) {
                //then we have a subarray
                ans += remFreq.get(rem);
                remFreq.put(rem, remFreq.get(rem) + 1);
            } else {
                remFreq.put(rem, 1);
            }
        }





        return ans;
    }
}
