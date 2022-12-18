package Easy_Questions_and_Concepts;

public class Product_of_Digits
{
    public static void main(String[] args) {
        System.out.println(Product(1342));
    }
    static int Product(int n)
    {
        //product of digits of that no
        //but here for n == 0 we can't just return 0 as then the whole ans would be 0, so...
        //hence if just one digit is remaining then return that digit
        if (n%10==n)
        {
            return n;
        }
        return (Product(n/10)) * (n%10);
    }
}
