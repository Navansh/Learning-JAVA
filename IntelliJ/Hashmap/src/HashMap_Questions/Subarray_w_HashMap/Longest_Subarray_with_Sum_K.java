package HashMap_Questions.Subarray_w_HashMap;

import java.util.HashMap;

public class Longest_Subarray_with_Sum_K {
    public static void main(String[] args) {

    }

    public static int lenOfLongSubarr (int[] nums, int N, int k) {
        //Complete the function
        HashMap<Integer, Integer> hx = new HashMap<>();
        HashMap<Integer, Integer> hy = new HashMap<>();
        //this stores the prefixSum and the index on which it appeared
        int pSum = 0;
        for(int i = 0; i < nums.length; i++) {
            //to handle the case where the longest subarray starts
            //from the 0th index, we first check and put the 0 as prefixSum
            //at 0th index and then add
            //essentalli we are adding the prefixSum till index - 1
            //when we are at index
            //this let's us directly ask for this prefixSum
            //when we query for it using the sumReq, as that sumReq is
            //prefix[startPoint - 1], which we are directly storing
            //hence we just return index and not index + 1
            if(hy.containsKey(pSum)) {
                //if its already present then we don't modify it, cz
                //for it to be the longest subarray the diff b/w start and end
                //index should be max and for that
            } else {
                hy.put(pSum, i);
            }
            pSum += nums[i];
        }

        hx.put(0 ,1);
        //this handles the case when the number (the prefixSum )
        //itself becomes equal to k
        //which means handling the case where the subarray starts
        //from 0th index

        //now start iterating the array and find eligible start
        //points for the given end points
        int ans = 0;
        int maxLen = 0;
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
                int idx = hy.get(sumReq);
                int len = i - idx + 1;
                maxLen = Math.max(maxLen, len);

            }

            //now add this endPoint to the HashMap, to be used
            //as a future start point
            hx.put(prefixSum, hx.getOrDefault(prefixSum, 0) + 1);
        }

        return maxLen;
    }
}
