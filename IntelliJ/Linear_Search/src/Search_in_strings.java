import java.util.Arrays;

public class Search_in_strings
{
    public static void main(String[] args)
    {
        String name = "Navansh";
        char target ='a';
//        System.out.println(search(name,target));
        //we can also convert this string into char array first and then directly compare
        //for that we use str.toCharArray()
//        System.out.println(Arrays.toString(name.toCharArray()));
        // ^^^^ Printed each letter of the name in an array
        System.out.println(search2(name,target));

    }

    static boolean search2(String str,char target)
    {
        if (str.length()==0)
        {
            System.out.println("Abe o string ki length badhawaa");
            return false;
        }

        for (char ch : str.toCharArray())
        {
            if (ch==target)
            {
                return true;
            }
        }
        return false;
    }

    static boolean search(String str,char target)
    {
        if (str.length()==0)
        {
            System.out.println("Abe o string ki length badhawaa");
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (target == str.charAt(i))
            {
                return true;
            }
        }
        return false;
    }
}
