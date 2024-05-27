package Array_Questions.SubArrays;

public class Bounded_Maximum {
    public static void main(String[] args) {
//https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/

    }

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {

        //let's fixate every index as an endpoint for once and check our cases there
        //three cases will be formed

        int ans = 0;
        //this contains the final count
        int lgei = 0;
        //and this contains an index, specifically : Least greater than EndPoint Index
        int prevValidCount = 0;
        //this will be used in the third case when we want to find a valid start point
        //which would have anyways previously calculated, as that would've been caught
        //in the second condition, because in the 3rd condition we want to look
        //for the element that satisfies that the max always stays between left and right
        for (int i = 0; i < nums.length; i++) {
            //the 'i' here represents an endPoint that we have fixated for each iteration
            // , and then we try to find the valid start points using the below cases
            //and then finally add them all up to form our answer

            if(nums[i] > right) {
                ans += 0;
                lgei = i + 1;
                //because as we are moving towards right, well update this
                //but for the next iterations if any of the other conditions
                //are true instead of this, then atleast we have a track of
                //what was the Least greater than EndPoint Index
                prevValidCount = 0;
                //because there is no validCount now, because we've got a number
                //that nullifies our condition, we would have to reset our var
                //to reflect that we're now starting fresh from here
                //and can't consider any prev answers
            } else if (nums[i] <= right && nums[i] >= left) {
                ans += (i - lgei + 1);
                prevValidCount = i - lgei + 1;
            } else {
                //meaning the case will be : nums[i] < left
                ans += prevValidCount;
            }
        }

        return ans;

    }
}
