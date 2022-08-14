import java.util.Scanner;

public class Conditions {
    public static void main(String[] args) {
        //Print numbers from 1 to 5
        Scanner in= new Scanner(System.in);
//        System.out.println("Enter any number");
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        //Q : Find the largest of the three numbers
//        for (int num1 = 1;num1<num;num1++)
//        {
//            System.out.println(num1);
//        }

        int max = Math.max(Math.max(a,c),b);
        System.out.println(max);

    }
}
