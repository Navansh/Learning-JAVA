package Stack_Questions.Prefix_Sum;

import java.util.Stack;

public class Running_Sum_of_1D {
    public static void main(String[] args) {

    }
    public static int[] runningSum(int[] nums) {
        Stack<Integer> stacker = new Stack<>();
        stacker.add(nums[0]);

        for(int i = 1; i < nums.length; i++) {
            //peek the element from the stack, add the arr[i] to it and it to the stack
            int ele1 = stacker.peek();
            stacker.add(nums[i] + ele1);
        }

        int[] ansArray = new int[nums.length];

        for(int i = nums.length - 1; i >= 0; i--) {
            ansArray[i] = stacker.pop();
        }

        return ansArray;

    }

    public static int[] runningSumOptimized(int[] nums) {
        for(int i=1;i<nums.length;i++){
            nums[i]=nums[i-1]+nums[i];

        }
        return nums;
    }
}
