package Recursion;

public class Subst_XOR_Sum {
    public static void main(String[] args) {
        //https://leetcode.com/problems/sum-of-all-subset-xor-totals/description/
    }

    public int subsetXORSumOptimized(int[] nums) {
        int result = 0;
        for(int n : nums) {
            result = result | n;
        }

        return result << (nums.length - 1);
        //this is simply result X 2^nums.length - 1
    }

    public int subsetXORSum(int[] nums) {
        //given an array nums, calculate the XOR of all subsets of nums
        return XORhelper(0,0,nums);
    }

    private int XORhelper(int i, int total, int[] nums) {
        if(i == nums.length) {
            return total;
        }

        int a = XORhelper(i + 1, total ^ nums[i], nums);
        int b = XORhelper(i + 1, total, nums);

        // hence in the first we included this number and
        // in second we didn't include this number so as to form the tree

        return a + b;
        //doing addition cz hamein subsets ke andar ke elements mein XOR karna
        //and all subsets ko add karna
        //so a & b represent subsets
    }
}
