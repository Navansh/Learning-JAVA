package Bitwise_Operators;


import java.util.Arrays;

public class Single_Number_3 {
    public static void main(String[] args) {
        int[] arr = {43772400,1674008457,1779561093,744132272,1674008457,448610617,1779561093,124075538,-1034600064,49040018,612881857,390719949,-359290212,-812493625,124732,-1361696369,49040018,-145417756,-812493625,2078552599,1568689850,865876872,865876872,-1471385435,1816352571,1793963758,2078552599,-1034600064,1475115274,-119634980,124732,661111294,-1813882010,1568689850,448610617,1347212898,-1293494866,612881857,661111294,-1361696369,1816352571,-1813882010,-359290212,1475115274,1793963758,1347212898,43772400,-1471385435,124075538,-1293494866,-119634980,390719949};
        System.out.println(Arrays.toString(singleNumber3(arr)));
    }

    public static int[] singleNumber3(int[] nums) {
        if(nums.length == 2) {
            return nums;
        }

        int[] ans = new int[2];

        long calc_xor = 0;
        for (int i = 0; i < nums.length; i++) {
            calc_xor = calc_xor ^ nums[i];
        }

        //now we are left with XOR of our resultant numbers
        //now we segregate them
        //pick any bitIndex which has 1 in it

        long checker = calc_xor;
        int bit_index = 0;

        while(checker != 0) {
            //check its last bit index
            if((checker & 1) == 1) {
                break;
            }
            checker = checker >> 1;
            bit_index++;
        }

        //now we got the bitIndex that has 1 in it
        long set1Ans = 0;
        //set 1 has the numbers XORed that have their bitIndex position as 0
        long set2Ans = 0;
        //set 1 has the numbers XORed that have their bitIndex position as 1

        for (int i = 0; i < nums.length; i++) {
            if(checkBit(nums[i],bit_index)) {
                //this means this bit is 1
                //put in set 2
                set2Ans = set2Ans ^ nums[i];
            } else {
                set1Ans = set1Ans ^ nums[i];
            }
        }

        ans[0] = (int) set1Ans;
        ans[1] =  (int) set2Ans;

        return ans;

    }

    private static boolean checkBit(int num, int bitIndex) {
        return (1 & (num >> bitIndex)) == 1;
    }


    public static int[] singleNumber(int[] nums) {
        int[] ans = new int[2];

        int calc_xor = 0;
        for (int i = 0; i < nums.length; i++) {
            calc_xor = calc_xor ^ nums[i];
        }

        //now we are left with XOR of our resultant numbers
        //now we segregate them
        //pick any bitIndex which has 1 in it

        int checker = calc_xor;
        int bit_index = 0;

        while((checker & (1 << bit_index)) == 0){
            bit_index++;
        }

        //now we got the bitIndex that has 1 in it
        int set1Ans = 0;
        //set 1 has the numbers XORed that have their bitIndex position as 0
        int set2Ans = 0;
        //set 1 has the numbers XORed that have their bitIndex position as 1

        for (int i = 0; i < nums.length; i++) {
            if((nums[i] & (1 << bit_index)) != 0) {
                //this means this bit is 1
                //put in set 2
                set2Ans = set2Ans ^ nums[i];
            } else {
                set1Ans = set1Ans ^ nums[i];
            }
        }

        ans[0] = set1Ans;
        ans[1] = set2Ans;

        return ans;

    }
}
