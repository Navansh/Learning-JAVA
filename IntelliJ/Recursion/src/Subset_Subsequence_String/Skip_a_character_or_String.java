package Subset_Subsequence_String;

public class Skip_a_character_or_String
{
    public static void main(String[] args) {
        skip("","baccad",'b');
        //hence the char to be skipped is added in skippu
        String s = skip("bccada",'a');
        System.out.println(s);
        System.out.println(skipString("Bakalavapplekorea","apple"));
        System.out.println(skipStringif("Bakalavapplkorea","app"));
    }
    //1st method
    static void skip(String processed,String unprocessed,char skippu)
    {
        //base condition
        if (unprocessed.isEmpty())
        {
            System.out.println(processed);
            return;
        }
        //else extract the first character of the unprocessed string and check it to the char you want to skip
        char ch = unprocessed.charAt(0);
        if (ch==skippu)
        {
            //then skip adding this char to the processed and move on with removing that char from the unprocessed string
            //hence creating a substring
            skip(processed,unprocessed.substring(1),skippu);
        }
        else {
            skip(processed+ch,unprocessed.substring(1),skippu);
            //we are adding that char to the processes and removing that char from the unprocessed string
        }
    }

    //2nd method - with String return type, this is called method
    static String skip(String unprocessed,char skippu)
    {
        //base condition
        if (unprocessed.isEmpty())
        {
            return "";
            //returning an empty string
        }
        //else extract the first character of the unprocessed string and check it to the char you want to skip
        char ch = unprocessed.charAt(0);
        if (ch==skippu)
        {
            //then skip adding this char to the processed and move on with removing that char from the unprocessed string
            //hence creating a substring
            return skip(unprocessed.substring(1),skippu);
        }
        else {
            return ch+skip(unprocessed.substring(1),skippu);
            //we are adding that char to the return value and removing that char from the unprocessed string
        }
    }
    static String skipString(String unprocessed,String skippu)
    {
        //base condition
        if (unprocessed.isEmpty())
        {
            return "";
            //returning an empty string
        }
        //we just need to check that at current value we are, does that start from "skippu" or not
        if (unprocessed.startsWith(skippu))
        {
            //then skip adding this char to the processed and move on with removing that char from the unprocessed string
            //hence creating a substring
            return skipString(unprocessed.substring(skippu.length()),skippu);
        }
        else {
            return unprocessed.charAt(0)+skipString(unprocessed.substring(1),skippu);
            //we are adding that char to the return value and removing that char from the unprocessed string
            //hence as we know that this string is not being skipped hence we just move forward one character
            // in the substring
        }
    }
    static String skipStringif(String unprocessed,String skippu)
    {
        //base condition
        if (unprocessed.isEmpty())
        {
            return "";
            //returning an empty string
        }
        //we just need to check that at current value we are, does that start from "skippu" or not
        if (unprocessed.startsWith(skippu)&&!unprocessed.startsWith("apple"))
        {
            //then skip adding this char to the processed and move on with removing that char from the unprocessed string
            //hence creating a substring
            return skipStringif(unprocessed.substring(skippu.length()),skippu);
        }
        else {
            return unprocessed.charAt(0)+skipStringif(unprocessed.substring(1),skippu);
            //we are adding that char to the return value and removing that char from the unprocessed string
            //hence as we know that this string is not being skipped hence we just move forward one character
            // in the substring
        }
    }
}
