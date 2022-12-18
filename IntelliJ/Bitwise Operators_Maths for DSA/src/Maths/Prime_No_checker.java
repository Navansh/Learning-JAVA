package Maths;

public class Prime_No_checker
{
    public static void main(String[] args)
    {
        int n =37;
        for (int i = 0; i <= n; i++)
        //we also include the last no i.e. n in i's range as it may also be prime and
            //in that case we'll lose that number
        {
            if (PrimeOrNot(i))
            {
                System.out.println(i);
            }
        }
    }
    static boolean PrimeOrNot(int n)
    {
        if (n<=1)
        {
            return false;
        }
        int divide = 2;
        //start from 2
        while (divide*divide<=n)
        {
            if (n%divide==0)
            {
                return false;
            }
            divide++;
        }
        return true;
    }
}
