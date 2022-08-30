import java.util.ArrayList;
import java.util.Scanner;

public class Multi_D_ArrayList
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();


        //intialising
        for (int i = 0; i < 3; i++)
        {
            list.add(new ArrayList<>());
        }
        //if we don't add it here then in the input stage how will we use get(i)

        //input elements
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                list.get(i).add(in.nextInt());
            }
        }

        //you can also print multi-dimensional arrays using sout(list)
        System.out.println(list);

    }
}
