package Subset_Subsequence_String;

import java.util.ArrayList;

public class Subsequence
{
    static ArrayList<String> listr = new ArrayList<>();
    //subsequence is for string and subsets is for arrays
    public static void main(String[] args) {
//        Subseq("","abc");
//        Subseq1("","alan");
//        System.out.println(listr);
//        System.out.println(SubseqArraylist("","abcd"));

            System.out.println(Subsequer("","abc",listr));
//        System.out.println(SubseqArraylistASCII("","abc"));

    }

    //add edge cases to ignore the empty strings
    //1st
    static void Subseq(String processed,String unprocessed)
    {
        //so whenever the unprocessed is empty then return the processed
        if (unprocessed.isEmpty())
        {
            System.out.print(processed);
            System.out.print(", ");
            return;
        }
        //now take the first char and make 2 recursion calls:- 1.)take it or 2.)ignore it
        char ch = unprocessed.charAt(0);

        Subseq(processed+ch,unprocessed.substring(1));
        //processed + ch : creates a new object, as strings are immutable
        //likewise unp.substring : creates a new string
        Subseq(processed,unprocessed.substring(1));

    }

        //here we are passing Arraylist as an argument
    //2
    static ArrayList<String> Subsequer(String processed,String unprocessed,ArrayList<String> list)
    {
        //so whenever the unprocessed is empty then return the processed
        if (unprocessed.isEmpty())
        {
            list.add(processed);
            return list;
        }
        //now take the first char and make 2 recursion calls:- 1.)take it or 2.)ignore it
        char ch = unprocessed.charAt(0);

        Subsequer(processed,unprocessed.substring(1),list);
        return Subsequer(processed+ch,unprocessed.substring(1),list);
        //w/o return function nhi maanega, otherwise yahaan par bhi return nhi karte
    }

    //storing in arraylist instead of printing answer, but Arraylist is not passed in arguments
    //and is also not in the body of the function rather it is declared outside the function
    //so not the poora poora way of doing recursion
    static void Subseq1(String processed, String unprocessed)
    {
        //so whenever the unprocessed is empty then return the processed
        if (unprocessed.isEmpty())
        {
            listr.add(processed);
            return;
        }
        //now take the first char and make 2 recursion calls:- 1.)take it or 2.)ignore it
        char ch = unprocessed.charAt(0);

         Subseq1(processed+ch,unprocessed.substring(1));
         Subseq1(processed,unprocessed.substring(1));
    }



    //here we'll initialize an arraylist inside the function

    static ArrayList<String> SubseqArraylist(String processed,String unprocessed)
    {
        //so whenever the unprocessed is empty then return the processed
        ArrayList<String> listerr = new ArrayList<>();
        //*** this is created for every func call
        if (unprocessed.isEmpty())
        {
            listerr.add(processed);
            return listerr;
        }
        //now take the first char and make 2 recursion calls:- 1.)take it or 2.)ignore it
        char ch = unprocessed.charAt(0);

        ArrayList<String> left = SubseqArraylist(processed+ch,unprocessed.substring(1));
        ArrayList<String> right = SubseqArraylist(processed,unprocessed.substring(1));

        //these are we can say local answers for that function call and when these go up the func calls
        //they get added to the main list
         //now these both Arraylists contain answers from both the halves of func calls
//        hence add them now
        //
        left.addAll(right);
        return left;  //
    }

    static void SubseqASCII(String processed,String unprocessed)
    {
        //so whenever the unprocessed is empty then return the processed
        if (unprocessed.isEmpty())
        {
            System.out.print(processed);
            System.out.print(", ");
            return;
        }
        //now take the first char and make 2 recursion calls:- 1.)take it or 2.)ignore it
        char ch = unprocessed.charAt(0);

        SubseqASCII(processed+ch,unprocessed.substring(1));
        SubseqASCII(processed,unprocessed.substring(1));
        SubseqASCII(processed+(ch+0),unprocessed.substring(1));
        //"ch+0" allows us to print the ASCII values
    }
    static ArrayList<String> SubseqArraylistASCII(String processed,String unprocessed)
    {
        //so whenever the unprocessed is empty then return the processed
        ArrayList<String> listerr = new ArrayList<>();
        if (unprocessed.isEmpty())
        {
            listerr.add(processed);
            return listerr;
        }
        //now take the first char and make 2 recursion calls:- 1.)take it or 2.)ignore it
        char ch = unprocessed.charAt(0);

        ArrayList<String> first = SubseqArraylistASCII(processed+ch,unprocessed.substring(1));
        ArrayList<String> second = SubseqArraylistASCII(processed,unprocessed.substring(1));
        ArrayList<String> third = SubseqArraylistASCII(processed+(ch+0),unprocessed.substring(1));


        //these are we can say local answers for that function call and when these go up the func calls
        //they get added to the main list

       first.addAll(second);
       first.addAll(third);
        return first;
    }

}
