package Basics;

public class Count_any_No
{
    public static void main(String[] args) {
        System.out.println(NoZeroes(00000));
    }
    //let's say we are counting here no of Zeroes
    //special pattern, how to pass same value to above calls
    public static int NoZeroes(int n)
    {
        return helper(n,0);
        //means initially the no of zeroes is 0
    }

    private static int helper(int n, int count) {
        if (n==0)
        {
            return count;
        }
        if (n%10==0)
        {
            return helper(n/10,count+1);
        }
        return helper(n/10,count);

    }
}
