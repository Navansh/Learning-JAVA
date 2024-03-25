package Maths;

public class Subarrays_with_GCD_equal_to_K {
    public static void main(String[] args) {

    }
    public static int subarrayGCDBruteforce(int[] nums, int k) {
        //calculate gcd for every subarray and check if its equal to k

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int ans = 0;
            for (int j = i; j < nums.length; j++) {
                ans = GCD(ans, nums[j]);
                if(ans< k) {
                    //we are checking for ans < k ******
                    //as GCD can never increase, so if GCD at this point of loop is less than k
                    //then there is no point iterating further
                    break;
                }
                if(ans == k) {
                    count++;
                }
            }
        }

        return count;
    }

    static int GCD(int a,int b)
    {
        if (a==0)
        {
            return b;
        }
        return GCD(b%a,a);
    }
}
