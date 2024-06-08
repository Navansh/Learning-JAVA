package Bitwise_Operators;

public class Power_calculator
{
    public static void main(String[] args) {
        int base = 2;
        int power = 12;
        //and we have to find a^b

        int ans =1 ;
        while(power>0)
        {
            if ((power&1)==1)
            {
                ans = ans*base;
            }
            base = base*base;
            //decrementing the power every iteration
            power = power >> 1;
        }
        System.out.println(ans);
    }
}
