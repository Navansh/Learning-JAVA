package Array_Questions.Prefix_Sum;

public class Trapping_RainWater {
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(arr));
    }

    public static int trap(int[] height) {
        //we'll first calculate prefixMax and suffixMax and use that to calculate
        //the amount of trapped water for the ith index

        //calculating the prefixMax Array
        //this gives the max value from the left side of ith till ith index (including it)
        int[] pMax = new int[height.length];
        pMax[0] = height[0];

        for (int i = 1; i < height.length; i++) {
            pMax[i] = Math.max(pMax[i - 1], height[i]);
        }

        //calculating the suffixMax Array
        //gives the max value from the right side of ith index in the array
        //including ith index
        int[] sMax = new int[height.length];
        sMax[height.length - 1] = height[height.length - 1];

        for (int i = height.length - 2; i >= 0; i--) {
            sMax[i] = Math.max(sMax[i + 1], height[i]);
        }

        //now calculate the contribution for each ith index
        //Obs : 0th index and last index won't collect any water, because they don't
        //have the other supporting structure beside them, they just have one

        int contri = 0;

        for(int i = 1; i < height.length - 1; i++) {
            int leftBlockade = pMax[i-1];
            int rightBlockade = sMax[i + 1];

            int yourBlockade = Math.min(leftBlockade, rightBlockade);
            int ourContri = yourBlockade - height[i];

            if(ourContri > 0) {
                contri += ourContri;
            }
        }

        return contri;

    }
}
