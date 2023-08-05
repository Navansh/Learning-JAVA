import java.util.Arrays;
import java.util.Scanner;

public class Array_2D
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int[][] arr = new int[3][3];
        
//        int[][] arr2 = {
//                {1,2}, //0 th index
//                {4,5,6}, //1st index
//                {7,8,9,3}//variable column length is possible but row size should be declared first
//        };

        //input
//        for (int i = 0; i < arr.length; i++)
//        {
//            for (int col = 0; col < arr[i].length; col++)
//            {
//                arr[i][col] = in.nextInt();
//
//            }
//        }

        //output
//        for (int[] ints : arr2) {
//            for (int anInt : ints) {
//                System.out.print(anInt + " ");
//
//            }
//            System.out.println();
//        }


        //or a simpler way would be to use Arrays.toStrings
//        for (int[] a : arr2) {
//            System.out.println(Arrays.toString(a));
//            //no need to take care of printing a new line or adding commas
//        }

        System.out.println(arr[1][1]);

    }

}
