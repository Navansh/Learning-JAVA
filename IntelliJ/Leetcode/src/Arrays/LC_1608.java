package Arrays;

import java.util.Arrays;

public class LC_1608 {
    public static void main(String[] args) {

    }

    public static int specialArrayOptimized(int[] nums) {
        int n = nums.length;
        int count = 0;
        int[] freq = new int[n + 1];
        //0,0,3,6,4,4
        for (int el : nums) {
            freq[Math.min(n, el)]++;
            //we're doing this because our ans can only be in the range of 1 to n
            //both inclusive, now if any ele in our array is greater than n
            //then for our freq array, we count it as greater than n,
            //and hence increase its freq as anyways the ans is gonna 
        }

        for (int i = n; i >= 1; i--) {
            //hence this loop will check for all the numbers, present in the array
            //as well as those are not present
            count += freq[i];
            if (count == i) return i;
        }

        return -1;
    }

    public static int specialArray(int[] nums) {
        int i = 0;
        int prev = -1;
        //this way it cannot be in the array and hence for the first integer
        //it will work and 0 cannot be the answer for this question
        //as we don't have 0 length or an empty array as input
        Arrays.sort(nums);
        int no_greater_than_or_equal_x = nums.length;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] == no_greater_than_or_equal_x) {
                return no_greater_than_or_equal_x;
            } else if(no_greater_than_or_equal_x > prev && no_greater_than_or_equal_x < nums[j]) {
                return no_greater_than_or_equal_x;
            }

            while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                j++;
            }
            prev = nums[j];
            no_greater_than_or_equal_x = nums.length - j;

            
        }

        return -1;
    }
}
