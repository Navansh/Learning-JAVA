public class ques_1
{
    public static void main(String[] args) {
        int n =4421;
        int return1 = fun(n);
        System.out.println(return1);


    }
    static int fun(int n)
    {
        int product = 1;
        int rem = 0;
        int num;
        while(n>0)
        {
            num = n%10;
            rem = rem + num;
            product = product*num;
            n = n/10;
        }
        return(product-rem);
    }

}
