package Bitwise_Operators;

import static java.lang.Math.ceil;

public class No_of_digits_in_Number
{
    public static void main(String[] args) {
        int n = 34567;
        int base = 2;

        int ans = (int) ceil((Math.log(n))/Math.log(base));
        System.out.println(ans);
    }
}
