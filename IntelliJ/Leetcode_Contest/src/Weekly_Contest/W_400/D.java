package Weekly_Contest.W_400;

public class D {
    public static void main(String[] args) {
        //https://leetcode.com/problems/find-subarray-with-bitwise-and-closest-to-k/
        int[] nums = {1,2,4,5};
        int k = 3;
        System.out.println(minimumDifferenceOptimized(nums,k));
    }

    public static int minimumDifferenceOptimized(int[] nums, int k) {
        int[] count = new int[32];
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;

        while (right < nums.length) {
            addBit(count, nums[right],right);
            int currentAns = calcAND(count, right - left + 1);
            //(right - left + 1) -> no of numbers in between left and right
            int absoluteDifference = Math.abs(currentAns - k);
            ans = Math.min(currentAns, absoluteDifference);

            while (left <= right && currentAns < k) {
                removeBit(count, nums[left], left);
                left++;
                currentAns = calcAND(count, right - left + 1);
                //(right - left + 1) -> no of numbers in between left and right
                absoluteDifference = Math.abs(currentAns - k);
                ans = Math.min(currentAns, absoluteDifference);
            }
            right++;
        }

        return ans;
    }

    private static int calcAND(int[] count, int i) {
        int val = 0;
        int power = 1;
        for (int j = 0; j < 32; j++) {
            if(count[i] == i) {
                //then consider this bit as set
                val += power;
            }
            power *= 2;
        }

        return val;
    }

    private static void addBit(int[] count, int num, int i) {
        int mask = 1 << i;
        if ((mask & num) != 0 ) {
            count[i]++;
        }
    }

    private static void removeBit(int[] count, int num, int i) {
        int mask = 1 << i;
        if ((mask & num) != 0 ) {
            count[i]--;
        }
    }

    public int minimumDifference(int[] nums, int k) {
        //O(N^2) solution
        int ans = Integer.MAX_VALUE;

        //now calculate all the subarrays
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = i; j < nums.length; j++) {
                num = num & nums[i];
                //hence essentially num carries the prefixAND for the range
                int absoluteDifference = Math.abs(k - num);
                if(absoluteDifference == 0) {
                    return 0;
                    //as isse min absolute difference toh nhi mil sakta
                }
                ans = Math.min(ans, absoluteDifference);

            }
        }

        return ans;
    }

}
