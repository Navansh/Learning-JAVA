package Questions.SubArrays;

public class Kadanes_Algo {
    public static void main(String[] args) {
        //used to find the maximum subArray

    }

    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if(sum >= 0) {
                //then add the current value to it
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            ans = Math.max(sum, ans);
        }

        return ans;
    }
}
