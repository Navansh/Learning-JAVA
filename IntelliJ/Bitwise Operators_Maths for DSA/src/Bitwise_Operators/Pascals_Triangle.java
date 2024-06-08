package Bitwise_Operators;

public class Pascals_Triangle
{
    public static void main(String[] args) {
        //sum of nth row of pascal's triangle
        /*
        1
        1 1
        1 2 1
        1 3 3 1
        1 4 6 4 1
        1 5 10 10 5 1
         */
        int row_no = 5;
        System.out.println(1<<(row_no-1));
    }
}
