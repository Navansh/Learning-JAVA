public class Factorial
{
    public static void main(String[] args) {
    int fact = Fact(4);
        System.out.println(fact);
    }
    static int Fact(int n)
    {
        if (n<=1){
            return 1;
        }
        int fact = n * Fact(n-1);
        return fact;

    }
}
