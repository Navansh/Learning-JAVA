import java.util.Scanner;

public class Questions
{
    public static void main(String[] args)
    {
        //to find prime or not
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        System.out.println(isPrime(num));
    }

    static boolean isPrime(int num)
    {
        int c =2;
        if (num<=1)
        {
            return false;
        }
        else
        {
            while(c*c<=num)
            {
                if(num%c==0)
                {
                    return false;
                }
                c++;
            }
            return c * c > num;
        }
    }


}
