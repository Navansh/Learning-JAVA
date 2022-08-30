import java.util.Scanner;

public class ArrayList1
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
        //slower thn traditional array

        //taking input manually
//        list.add(45);

        //taking input using for loop
        for (int i = 0; i < 5; i++)
        {
            list.add(in.nextInt());
        }

        System.out.println(list);
    }
}
