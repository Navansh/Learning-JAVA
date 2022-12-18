package Bitwise_Operators;

public class Count_No_of_set_bits
{
    public static void main(String[] args) {
        int n = 22343;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(SetBitsinNo(n));
    }

    private static int SetBitsinNo(int n) {
        int count = 0;
//Way#1
//        while (n>0)
//        {
//            count++;
//            n = n - (n&(-n));
//        }
//        OR

//        Way #2
        while (n>0)
        {
            count++;
            n = n&(n-1);
        }

        return count;
    }

}
