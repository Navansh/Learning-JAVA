package Array_Questions.SubArrays;

public class Max_Product_Subarray {
    public static void main(String[] args) {
        //here we have to find the max product possible for each subarray
        //all the approaches have been listed in the copy, we're here doing the
        //most optimized approach
    }

    public static int maxProduct(int[] nums) {
        //this till uses O(N) space, made it more efficient below
        //implement prefixProduct for the array
        int[] prefixProduct = new int[nums.length];
        prefixProduct[0] = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if(prefixProduct[i - 1] == 0) {
                //set it to the last value
                prefixProduct[i] = nums[i];
            } else {
                prefixProduct[i] = prefixProduct[i - 1] *nums[i];
            }
            max = Math.max(prefixProduct[i], max );
        }

        //now do the suffixProduct

        int[] suffixProduct = new int[nums.length];
        suffixProduct[nums.length - 1] = nums[nums.length - 1];
        max = Math.max(suffixProduct[nums.length - 1], max );

        for (int i = nums.length - 2; i >= 0; i--) {
            if(suffixProduct[i + 1] == 0) {
                //set it to the last value
                suffixProduct[i] = nums[i];
            } else {
                suffixProduct[i] = suffixProduct[i + 1] * nums[i];
            }

            max = Math.max(suffixProduct[i], max );
        }

        return max;


    }

    public int maxProductOptimized(int[] nums) {
        //This now uses O(1) space
        int n = nums.length;

        int pf1 = 1;
        int max1 = Integer.MIN_VALUE;
        int pf2 = 1;
        int max2 = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            if(pf1 == 0){
                pf1 = nums[i];
            }else{
                pf1 = pf1 * nums[i];
            }

            max1 = Math.max(max1,pf1);
        }

        for(int i = n-1;i>=0;i--){
            if(pf2 == 0){
                pf2 = nums[i];
            }else{
                pf2 = pf2 * nums[i];
            }

            max2 = Math.max(max2,pf2);
        }

        return Math.max(max1,max2);
    }

}
