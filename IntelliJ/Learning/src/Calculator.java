import java.util.Scanner;

public class Calculator
{
    public static void main(String[] args)
    {
        System.out.println("Enter the Operator");
        Scanner in = new Scanner(System.in);
        while(true)
        {
            char op = in.next().trim().charAt(0);
            if (op=='+'|| op=='-'||op=='*'|| op =='/'||op=='%')
            {
                System.out.println("Enter 2 numbers");
                int num1 = in.nextInt();
                int num2 = in.nextInt();

                if (op == '+') {
                    int result = num1 + num2;
                    System.out.println(result);
                }
                if (op == '-') {
                    int result = num1 - num2;
                    System.out.println(result);
                }
                if (op == '*') {
                    int result = num1 * num2;
                    System.out.println(result);
                }
            }


            else if (op== 'X' || op == 'x')
            {
                    System.out.println("Program OVER!");
                    break;
            }

            else
            {
                System.out.println("Invalid operator");
            }


        }

    }

}
