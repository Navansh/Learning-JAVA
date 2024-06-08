package Bitwise_Operators;

public class XOR_bw_a_and_b
{
    public static void main(String[] args) {

        //Bitwise_Operators.XOR of range b/w a & b = Bitwise_Operators.XOR(b) ^ Bitwise_Operators.XOR(a-1)
        int a = 33232;
        int b =92424;

        int ans = PureXOR(b) ^ PureXOR(a-1);
        System.out.println(ans);

        //only for check as it will give TLE for Large Nos
        int ans2 = 0;
        for (int i = a; i <=b ; i++) {
            ans2 ^= i;
        }
        System.out.println(ans2);
    }

    public static int PureXOR(int a)
    {
//        this gives Bitwise_Operators.XOR from 0 to a
        if (a%4==0)
        {
            return a;
        } else if (a%4==1) {
            return 1;
        } else if ((a % 4) == 2) {
            return a+1;
        } else {
            return 0;
        }
    }
}
