package Maths;

public class GCD_and_LCM
{
    public static void main(String[] args) {
        System.out.println(GCD(0,2324));
        System.out.println(LCM(2,197));
    }
    static int GCD(int a,int b)
    {
        if (a==0)
        {
            return b;
        }
        return GCD(b%a,a);
    }
    static int LCM(int a,int b)
    {
        return (a*b)/GCD(a,b);
    }

}
