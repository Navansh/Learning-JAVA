package Questions.Prefix_Sum;

public class Product_of_Array_Except_Itself {
    public static void main(String[] args) {
//        https://leetcode.com/problems/product-of-array-except-self/description/

    }

    public int[] productExceptSelfOptimized(int[] nums) {
        //This is the optimal solution, which uses O(1) space
        //and TC is O(N)

        int[] prefProduct = new int[nums.length];
        prefProduct[0] = nums[0];

        //form the prefProduct array
        for(int i = 1; i < nums.length; i++) {
            prefProduct[i] = prefProduct[i - 1] * nums[i];
        }

        //now modify the prefProduct array, starting from last
        //such that this becomes the answer array
        //we'll do it using suffix

        int suffix = 1;

        for(int i = nums.length - 1; i > 0; i--) {
            prefProduct[i] = prefProduct[i - 1] * suffix;
            suffix = suffix * nums[i];
        }

        //at the end for the 0th index we do
        prefProduct[0] = suffix;

        return prefProduct;

    }

    public int[] productExceptSelf(int[] nums) {
        //calculate left product and right Product

        //calculating left product
        int[] leftProduct = new int[nums.length];
        leftProduct[0] = nums[0];

        for(int i = 1; i < nums.length; i++) {
            leftProduct[i] = leftProduct[i-1] * nums[i];
        }

        //calculate right product
        int[] rightProduct = new int[nums.length];
        rightProduct[nums.length - 1] = nums[nums.length - 1];

        for(int i = nums.length - 2; i >= 0; i--) {
            rightProduct[i] = rightProduct[i+1] * nums[i];
        }

        //now calculate the ans array
        int[] ansArray = new int[nums.length];

        for(int i = 1; i < nums.length - 1; i++ ) {
            ansArray[i] = leftProduct[i-1] * rightProduct[i + 1];
        }

        //handle the i = 0 scenario
        ansArray[0] = rightProduct[1];

        ansArray[nums.length - 1] = leftProduct[nums.length - 2];

        return ansArray;
    }


}
