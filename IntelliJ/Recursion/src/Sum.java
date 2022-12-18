public class Sum
{
    public static void main(String[] args) {
    int fact = Sum(4);
        System.out.println(fact);
    }
    static int Sum(int n)
    {
        //sum of nos from n to 1
        if (n<=1){
            return 1;
        }
        int fact = n + Sum(n-1);
        return fact;
    }
}
