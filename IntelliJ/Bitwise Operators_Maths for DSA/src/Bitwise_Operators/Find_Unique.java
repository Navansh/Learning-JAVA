package Bitwise_Operators;

public class Find_Unique
{
    //Given an array in which every no appears twice but only one no appears once find that no
    public static void main(String[] args)
    {
        int[] arr = {2,3,3,4,2,6,4};
        System.out.println(FindU(arr));
    }

    static int FindU(int[] arr)
    {
        //Ans-> Bitwise_Operators.XOR all no's
        //as a^a = 0, and 0^ any no is that no, hence that unique no will be the one remaining at last
        int unique = 0;
        for (int n : arr) {
            unique ^= n;
        }
        return unique;
    }
}
