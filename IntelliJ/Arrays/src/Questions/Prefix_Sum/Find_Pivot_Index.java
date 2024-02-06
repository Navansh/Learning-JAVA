package Questions.Prefix_Sum;

public class Find_Pivot_Index {
    public static void main(String[] args) {

    }

    public static int pivotIndex(int[] nums) {
        //calculate the leftSum array and rightSum array excluding i here
        //now for an i, if they both have equal values, then return i

        //calculate the leftSum array
        int[] leftSum = new int[nums.length];
        leftSum[0] = 0;

        for(int i = 1; i < nums.length; i++) {
            leftSum[i] = leftSum[i-1] + nums[i-1];
        }

        //calculate the rightSum array
        int[] rightSum = new int[nums.length];
        rightSum[nums.length - 1] = 0;

        for(int i = nums.length - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i + 1];
        }

        for(int i = 0; i < nums.length; i++) {
            if(rightSum[i] == leftSum[i]) {
                return i;
            }
        }

        return -1;
    }

    public static int pivotIndexAlternate(int[] nums) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];

        int ans = 0;
        //calculate the prefixSum for this array
        for(int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i -1] + nums[i];
        }

        //checking for the edge cases we left below
        //checking the i =0 case
        //hee leftsum is 0 and right sum is prefixSum[nums.length -1] - prefixSum[0]
        int ans1 = Integer.MAX_VALUE;
        int ans2 = Integer.MAX_VALUE;
        int ans3 = Integer.MAX_VALUE;



        for (int i = 1; i < nums.length - 1; i++) {
            //we are specifically leaving the edge cases when i is 0
            //or when i = nums.length - 1

            int leftSum = prefixSum[i - 1];
            int rightSum = prefixSum[nums.length - 1] - prefixSum[i];

            if(leftSum == rightSum) {
                ans3 = Math.min(ans3, i);
            }
        }

        if(prefixSum[nums.length -1] - prefixSum[0] == 0) {
            ans1 = 0;
        }

        //checking the i = last element, case
        //hee rightSum is 0 and right sum is prefixSum[nums.length -1] - prefixSum[0]
        if(nums.length -2 >= 0 && prefixSum[nums.length -2] == 0) {
            ans2 = nums.length -1;
        }

        //calculating the min value
        int min = Math.min(ans1, ans2);
        int min2 = Math.min(min, ans3);

        if(min2 != Integer.MAX_VALUE) {
            return min2;
        }

        return -1;

    }
}
