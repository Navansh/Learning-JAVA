package Bitwise_Operators;

public class Single_Number_2 {
    public static void main(String[] args) {

    }

    public static int singleNumber(int[] nums) {
        int ans = 0;

        //now as in integer, there are 32 bits, so we run a for loop for that
        for (int i = 0; i < 32; i++) {
            //i here shows the ith bit we are checking for all the integers in the array
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if(checkBit(nums[j],i)) {
                    //means the ith bit for this jth element is 1
                    //hence it will iterate over all the elements of the array
                    //and check their ith bit
                    count++;
                }
                //add count modulo 3 to the ans, as binary**
            }
            if(count % 3 == 1) {
                //add to ans
                ans = ans + (1 << i);
                //i is the ith bit, so we are actually adding 2 to the power i
            }
        }

        return ans;
    }

    public static int ThriceRepeating(int[] nums) {
        //all numbers are repeating 3 times, but one number is repeating 2 times
        int ans = 0;

        for(int i=0;i < 32;i++){
            int count = 0;
            for(int j=0;j<nums.length;j++){
                if(checkBit(nums[j], i)){
                    count++;
                }
            }

            if(count % 3 == 2){
                ans = ans + (1<<i);
            }
        }

        return ans;
    }

    public static int RepeatingFourTimes(int[] nums) {
        //all nos in the array are repeating 4 times, and there is only one
        //element which is repeating 1 time, find that
        int ans = 0;

        for(int i=0;i<nums.length;i++){
            ans = ans ^ nums[i];
        }

        return ans;
    }

    public static int RepeatingFourTimesBut(int[] nums) {
        //all nos in the array are repeating 4 times, and there is only one
        //element which is repeating 2 time, find that
        int ans = 0;

        for(int i=0;i < 32;i++){
            int count = 0;
            for(int j=0;j<nums.length;j++){
                if(checkBit(nums[j], i)){
                    count++;
                }
            }

            if(count % 4 == 2){
                ans = ans + (1<<i);
            }
        }

        return ans;
    }


    private static boolean checkBit(int num, int i) {
        //checks if the ith bit is 1 or not
        //shift the num rightwards i places and then take & with 1
        num = num >> i;
        return (num & 1) == 1;
    }
}
