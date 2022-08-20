import java.util.Scanner;

public class no_of_occurances_alphabet
{
    //counting the number of occurance of a specific alphabet whoch is entered by user
    public static void main(String[] args)
    {
        int count = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the word");
        String ch = in.nextLine().trim();
        int l = ch.length();
//        System.out.println(l);


        for (int i = 0; i < l ; i++)
        {
            char c = ch.charAt(i);
            if ( c =='l' )
            {
                count++;
            }
        }

        System.out.println(count);


    }
}
