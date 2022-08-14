import java.util.Scanner;

public class Fibonacci
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the position till which you want ");
        int num = in.nextInt();
        int a = 0;
        int b = 1;
        if (num==1)
        {
            System.out.println("0");
            return;
        }
        if (num==2)
        {
            System.out.println("1");
            return;
        }
        int temp = 0;
        for (int i = 0; i < num-1; i++)
        {
            temp = b + a;
            a = b;
            b = temp;
        }

        System.out.println(temp);
    }
}
