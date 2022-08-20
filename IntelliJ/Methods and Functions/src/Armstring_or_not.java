import java.util.Scanner;

public class Armstring_or_not {
    public static void main(String[] args) {

        // Print all the 3 digit armstrong numbers

        Scanner in = new Scanner(System.in);
        //3 digit = 100 to 999
        fun(1633, 1999);
    }

    static void fun(int a, int b) {
        int num = a;

        while(num<=b)
        {
            int sum = 0;
            int og = num;
            while(num>0) {
                int rem = num % 10;
                num = num / 10;
                sum = sum + (rem * rem * rem);
            }
            if (sum==og)
            {
                System.out.print(og);
                System.out.println(":  The number is an armstrong number ");
            }
            num=a++;
        }




    }



}
