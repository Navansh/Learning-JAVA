package Bitwise_Operators;

public class Kthbit_Set_or_Not {
    public static void main(String[] args) {
        System.out.println(checkKthBit(500,3));
    }

    public static boolean checkKthBit(int n, int k) {
        // Your code here
        //shift right k number of times and then & with 1
        //set is 1

        //shift the bit to right
        int set = n >> k;
        //right shift operator
        System.out.println(set);
        return (set & 1) == 1;
    }

    public static int setKthBit(int n, int k) {
        // Your code here
        // set the Kth bit to 1 and if already 1, then OK
        return (n | (1 << k));
    }

    public static int flipKthBit(int n, int k) {
        // Your code here
        // set the Kth bit to 1 and if already 1, then OK
        return (n ^ (1 << k));
    }

    public static int unsetKthBit(int n, int k) {
        // Your code here
        // set the Kth bit to 1 and if already 1, then OK
        if(checkKthBit(n,k)) {
            //if it is 1, then flip it
            return (n ^ (1 << k));
        }

        return n;
        //else, then nothing needs to be done
    }




}
