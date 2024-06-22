package HashMap_Questions.Subarray_w_HashMap;

import java.util.HashMap;

public class Subarray_with_k_odd_numbers {
    public static void main(String[] args) {

    }

    public int numberOfSubarrays(int[] nums, int k) {
        //subarray -> start and end
        //TC : O(n)
        if(k > nums.length) {
            return 0;
        }

        //similar to Sum equals k waali prob

        HashMap<Integer, Integer> hx = new HashMap<>();
        hx.put(0, 1);
        
        int ans = 0;
        int countOdd = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 != 0) {
                //meaning this is odd
                countOdd++;
            }

            int req = countOdd - k;
            if(hx.containsKey(req)) {
                //then add it to the ans
                ans += hx.get(req);
            }

            //now create a mapping for this
            hx.put(countOdd, hx.getOrDefault(countOdd, 0) + 1);
        }


        return ans;

    }

    public int numberOfSubarraysSliding(int[] nums, int k) {
        //this we'll do using sliding window technique
        //use of prevCount is imp

        int n = nums.length;
        int oddCount = 0;
        int prevCount = 0;
        int ans = 0;

        int i = 0;
        int j = 0;

        while (j < n) {
            if(nums[j] % 2 != 0) {
                oddCount++;
                prevCount = 0;
            }

            while (oddCount == k) {
                prevCount++;

                if(nums[i] % 2 != 0) {
                    oddCount--;
                }
                i++;
            }

            ans += prevCount;
            j++;
        }

        return ans;

    }
}
