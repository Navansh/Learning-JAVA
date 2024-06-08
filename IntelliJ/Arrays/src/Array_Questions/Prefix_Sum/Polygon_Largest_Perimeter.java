package Array_Questions.Prefix_Sum;

import java.util.Arrays;

public class Polygon_Largest_Perimeter {
    public static void main(String[] args) {
        int[] arr = {300005055,352368231,311935527,315829776,327065463,388851949,319541150,397875604,311309167,391897750,366860048,359976490,325522439,390648914,359891976,369105322,350430086,398592583,354559219,372400239,344759294,379931363,308829137,335032174,336962933,380797651,378305476,336617902,393487098,301391791,394314232,387440261,316040738,388074503,396614889,331609633,374723367,380418460,349845809,318514711,308782485,308291996,375362898,397542455,397628325,392446446,368662132,378781533,372327607,378737987};
        System.out.println(largestPerimeter(arr));
    }

    public static long largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        //now do the prefixSum
        long[] pSum = new long[nums.length];
        pSum[0] = nums[0];

        for(int i = 1; i < nums.length; i++) {
            pSum[i] = pSum[i - 1] + nums[i];
        }

        //now check for the condition of polygon, that is no of sides
        //should be greater than 3 and sum of k - 1 sides should be greater than
        //kth side
        int sides = 0;

        if(nums.length == 3) {
            if(nums[0] + nums[1] > nums[2]) {
                return nums[0] + nums[1] +nums[2];
            }
        }

        long ans = -1;

        for(int i = 2; i < nums.length; i++) {
            if(pSum[i - 1] > nums[i]) {
                //this is a polygon, continue further
                ans = pSum[i];
            }
        }

        return ans;
    }
}
