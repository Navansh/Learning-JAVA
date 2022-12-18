package Easy_Questions_and_Concepts;

public class Sum_of_Digits
{
    public static void main(String[] args) {
        System.out.println(Sum(1342));
    }
    static int Sum(int n)
    {
        if (n==0)
        {
            return 0;
        }

        return (Sum(n/10) + n%10);
    }
}
