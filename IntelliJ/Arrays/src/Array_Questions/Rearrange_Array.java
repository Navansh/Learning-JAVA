package Array_Questions;

import java.util.Arrays;

public class Rearrange_Array {
    public static void main(String[] args) {
        int[] arr = {28,-41,22,-8,-37,46,35,-9,18,-6,19,-26,-37,-10,-9,15,14,31};
        System.out.println(Arrays.toString(rearrangeArray(arr)));
    }

    public static int[] rearrangeArray(int[] nums) {
        int next_positive = 0;
        int next_negative = 0;
        int curr_index = 0;
        boolean next_req = false;

        //we'll find the index of the next positive, and next negative

        if(nums[0] > 0) {
            curr_index = 1;
        } else {
            next_positive = findPositive(nums, curr_index);
            swapper(0, next_positive, nums);
            curr_index = 1;
        }

        while(curr_index < nums.length) {
            //check if the current kiski baari and start from positive
            //if next-req is true -> it means we need positive here
            //else negative
            if(next_req) {
                if(nums[curr_index] > 0) {
                    curr_index++;
                } else {
                    next_positive = findPositive(nums, curr_index);
                    swapper(curr_index, next_positive, nums);
                    curr_index++;
                }
                next_req = false;
            } else {
                if(nums[curr_index] < 0) {
                    curr_index++;
                } else {
                    next_negative = findNegative(nums, curr_index);
                    swapper(curr_index, next_negative, nums);
                    curr_index++;
                }
                next_req = true;
            }
        }

        return nums;
    }

    public static int findPositive(int[] nums, int curr_index) {
        for(int i = curr_index + 1; i < nums.length; i++) {
            if(nums[i] > 0) {
                return i;
            }
        }

        return -1;
    }

    public static int findNegative(int[] nums, int curr_index) {
        for(int i = curr_index + 1; i < nums.length; i++) {
            if(nums[i] < 0) {
                return i;
            }
        }

        return -1;
    }

    public static void swapper(int a, int b, int[] nums) {
        //swap a index element with b index element
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
