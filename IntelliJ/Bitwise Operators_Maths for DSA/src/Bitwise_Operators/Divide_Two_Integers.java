package Bitwise_Operators;

public class Divide_Two_Integers {
    public static void main(String[] args) {
        // divide two integers without using multiplication, division, and mod operator.
        System.out.println(divide(45,8));
    }

    public static int divide(int dividend, int divisor) {
        long a = dividend;
        long b = divisor;

        int sign = 1;
        //1 or +1
        if(a < 0) {
            sign = sign * -1;
        }
        if(b < 0) {
            sign = sign * -1;
        }

        //now take the abs values of the nums
        a = Math.abs(a);
        b = Math.abs(b);


        int temp = 0;
        int quotient = 0;

        for (int i = 31; i >= 0; i++) {
            if(temp + (b << i) <= a) {
//                b << i simply means b * 2^i
                //as 1 << i is just 2^i and we are multiplying b to it
                //so now update the temp
                temp = (int) (temp + (b << i));
                quotient = (int) (quotient + ((long)1 << i));
                //through this we set the ith bit of the quotient
            }
        }

        if(sign < 0) {
            return -quotient;
        }

        if(quotient > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if(quotient < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return quotient;
    }
}
