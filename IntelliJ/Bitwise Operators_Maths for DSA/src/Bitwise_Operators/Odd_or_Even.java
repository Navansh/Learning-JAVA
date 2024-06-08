package Bitwise_Operators;

import java.util.SortedMap;

public class Odd_or_Even
{
    public static void main(String[] args) {
        OddEven(46);
    }
    public static void OddEven(int n)
    {
        if ((n&1)==1)
        {
            System.out.println("This is an odd number");
        }
        else
            System.out.println("This is an even number");
    }
}
