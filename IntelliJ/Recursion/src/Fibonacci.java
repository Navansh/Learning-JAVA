public class Fibonacci
{
    public static void main(String[] args) {
        System.out.println(Fib(6));
//        System.out.println(Fiboformula(50));
    }
    public static long Fiboformula(int n)
    {
        //calculating nth fibonacci no using formula
        //you can even remove the negative term and still get the answer as it is the less dominant term
        double ans =(Math.pow((1+ Math.sqrt(5))/2 , n)-(Math.pow((1- Math.sqrt(5) )/2 , n)))/Math.sqrt(5);
        return (long)ans;
    }
    public static int Fib(int n)
    {
        //base case:
        if (n==1||n==0)
            return n;

        return (Fib(n-1)+Fib(n-2));

    }
}
