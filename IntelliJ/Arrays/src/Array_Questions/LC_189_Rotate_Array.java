package Array_Questions;

public class LC_189_Rotate_Array {
    public static void main(String[] args) {
//    https://leetcode.com/problems/rotate-array/
    }

    public void rotate(int[] nums, int k) {
        //get the actual k which is
        k = k % nums.length;

        //reverse the first n - k elements
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
