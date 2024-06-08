package Array_Questions;

import java.util.Arrays;

public class Divide_arrays_into_arrays {
    public static void main(String[] args) {
        int[] nums = {6,10,5,12,7,11,6,6,12,12,11,7};
        int[][] ans = divideArray(nums, 2);
        for (int[] an : ans) {
            System.out.println(Arrays.toString(an));
        }
    }

    public static int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        //sort the array

        int[][] ansArray = new int[nums.length/3][3];
        //now verify the condition
        for (int i = 1; i < nums.length && i + 1 < nums.length; i+=3) {
            if(nums[i + 1] - nums[i - 1] <=k) {
                continue;
            } else {
                return new int[0][0];
            }
        }

        //now form the AnsArray
        for (int i = 0; i < nums.length / 3; i++) {
            ansArray[i][0] = nums[3*i];
            ansArray[i][1] = nums[3*i + 1];
            ansArray[i][2] = nums[3*i + 2];
        }

        return ansArray;


    }
}
