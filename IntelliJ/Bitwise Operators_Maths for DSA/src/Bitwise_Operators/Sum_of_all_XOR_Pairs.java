package Bitwise_Operators;

public class Sum_of_all_XOR_Pairs {
    public static void main(String[] args) {

    }

    public long sumXOR (int arr[], int n) {
        //we check the ith index for no of 1's ( or set bit )
        long ans = 0;
        for (int i = 31; i >= 0; i--) {
            //start from the 31st bit, you can start from 0 also and move to 31st bit
            //count all set bits that are in the ith place
            int count = 0;
            for(int ele : arr) {
                if(checkBit(ele,i)) {
                    count++;
                }
            }

            //add ans of this place to the main ans
            ans = ans + (long) count *(arr.length - count)*(1<<i);
        }

        return ans;

    }

    public static boolean checkBit(int ele, int position) {
        return ((ele >> position) & 1) == 1;
    }
}
