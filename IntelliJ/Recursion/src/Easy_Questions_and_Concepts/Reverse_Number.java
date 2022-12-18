package Easy_Questions_and_Concepts;

public class Reverse_Number
{
    static int sum = 0;
    static void RevNum(int n)
    {
        //not the pure recursion method as you have declared an outside variable and adding values to it
        if (n==0)
        {
            return;
        }
        int rem = n%10;
        sum = sum*10 + rem;
        RevNum(n/10);
    }

    static int RevNum2(int n)
    {
        //sometimes you might need some additional variables in the argument in that case make another function
        // that returns the value you want
        int digits = (int) (Math.log10(n) + 1);
        return helper(n,digits);
    }

    private static int helper(int n, int digits) {
        if (n%10==n)
        {
            return n;
        }
        int rem = n%10;
        return (int) (rem*Math.pow(10,digits-1) + helper(n/10,digits-1));
    }

    public static void main(String[] args) {
        System.out.println(RevNum2(1234));
    }

}
