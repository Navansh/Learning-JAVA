package HashMap_Questions.Subarray_w_HashMap;

import java.util.HashMap;

public class Subarray_Sum_Equals_K {
    public static void main(String[] args) {

    }

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hx = new HashMap<>();
        hx.put(0 ,1);
        //this handles the case when the number (the prefixSum )
        //itself becomes equal to k
        //which means handling the case where the subarray starts
        //from 0th index
        
        //now start iterating the array and find eligible start 
        //points for the given end points
        int ans = 0;
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) { //TC : O(N)
            prefixSum += nums[i];
            //we don't need to create the full prefixSum array
            //as we don't req, as differences are anyways stored
            //in our HashMap
            int endPoint = prefixSum;
            //now check if a valid start point exists for this
            int sumReq = endPoint - k;

            //now check if this exists in the hashmap
            if(hx.containsKey(sumReq)) {
                //then we got an eligible start point
                //hence an ( or more than 1 ) ans
                ans += hx.get(sumReq);
            }

            //now add this endPoint to the HashMap, to be used
            //as a future start point
            hx.put(prefixSum, hx.getOrDefault(prefixSum, 0) + 1);
        }

        return ans;
    }
}
