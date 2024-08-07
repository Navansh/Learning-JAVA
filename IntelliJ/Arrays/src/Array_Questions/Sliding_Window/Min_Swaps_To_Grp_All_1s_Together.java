package Array_Questions.Sliding_Window;

public class Min_Swaps_To_Grp_All_1s_Together {
    public static void main(String[] args) {

    }

    public int minSwaps(int[] nums) {
        //a window will be created of number of
        //1s in the array
        //now that size window we'll check ki kitne
        //0 hai, now that many min swaps are required
        //to get all the 1s together from 0s, so
        //we store this count and then move our window forward

        //first count the number of 1s in the array
        int countOne = 0;
        for(int num : nums) {
            if(num == 1) {
                countOne++;
            }
        }
        //size of window = countOne

        int i = 0;
        int j = 0;
        //we'll be handling the circular subarray thing
        //using modulo and no extra space

        //we need to maximize the count of ones in the window
        //or we can say minimize the countof 0
        //so we'll just hold the max count of one
        //and in the subtract from the total Count of ones
        //that we calculated from the array

        int n = nums.length;
        int currOnes = 0;
        int maxCount = 0;

        while (j < 2*n) {
            if(nums[j%n] == 1) {
                currOnes++;
            }

            if((j - i + 1 ) > currOnes) {
                //means we have a greater window size
                //so we shrink
                currOnes -= nums[i%n];
                //if i th index par 1 hoga toh minus
                //ho jaayega else same hi rahega
                i++;
                //and we shrink the size of window
                //by moving i forward
            }

            maxCount = Math.max(maxCount, currOnes);
            j++;
        }


        return countOne - maxCount;


    }
}
