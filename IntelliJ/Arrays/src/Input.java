import java.util.Arrays;
import java.util.Scanner;

public class Input
{
    public static void main(String[] args)
    {
        //either you can individually assign or take input using a for loop
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];


        //array of primitives
//        for (int i = 0; i < arr.length; i++)
//        {
//            System.out.println("Enter the number");
//            arr[i] = in.nextInt();
//        }
//        for (int j : arr) {
//            System.out.println(j);
//        }


        //Array of Objects
        String[] str = new String[5];
        for (int i = 0; i < str.length; i++)
        {
            str[i] = in.next();
        }

        System.out.println(Arrays.toString(str));
    }


}
