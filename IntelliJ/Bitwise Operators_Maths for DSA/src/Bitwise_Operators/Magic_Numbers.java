package Bitwise_Operators;

import static java.lang.Math.ceil;
import static java.lang.Math.floor;

public class Magic_Numbers
{
    public static void main(String[] args) {
        int n = 1;
        //say we find the 6th magic number
        int ans = 0;
        int base = 5;
        while(n>0)
        {
            int last_digit = n&1;
            n = n>>1;

            ans += last_digit*base;
            base = base*5;
        }
        System.out.println(ans);

//        int x = (int) ceil(4.5);
//        System.out.println(x);
    }
}
