package Bitwise_Operators;

public class Power_of_2_checker
{
    public static void main(String[] args) {
        int n = 10;
        //but here is an exception where when n =0, it still gives true which is wrong

        boolean ans = (n & (n-1)) == 0;
        System.out.println(ans);
    }
}
