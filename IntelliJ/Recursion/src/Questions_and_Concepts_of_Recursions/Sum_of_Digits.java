package Questions_and_Concepts_of_Recursions;

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
