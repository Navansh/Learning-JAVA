import java.util.Scanner;

public class prime_no {
    public static void main(String[] args) {
        Scanner no = new Scanner(System.in);
        System.out.println("Enter any number");
        int num = no.nextInt();
        if (num==1)
        {
            System.out.println("Neither prime nor composite");
            return;
        }
        int c=2;
        if (num==4)
        {
            System.out.println("Not prime");
        }
        while (c*c<num)
        {
            if (num%c==0)
            {
                System.out.println("Not prime");
                return;

            }
            c++;
        }
        if (c*c>num)
        {
            System.out.println("Prime");
        }


    }

}
