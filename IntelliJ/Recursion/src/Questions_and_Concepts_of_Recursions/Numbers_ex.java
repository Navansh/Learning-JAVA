package Questions_and_Concepts_of_Recursions;

public class Numbers_ex {
    public static void main(String[] args)
    {
        //print first 5 numbers
        printNumBoth(1);

    }
    static void printNum(int n)
    {
        if(n==5)
        {
            System.out.println(n);
            return;
        }
        System.out.println(n);
        //this is called Tail Recursion
        //as this is the last function call
        printNum(n+1);

    }
    static void printNumRev(int n)
    {
        if(n==6)
        {
            System.out.println(n);
            return;
        }
        //this is called Tail Recursion
        //as this is the last function call
        printNumRev(n+1);
        System.out.println(n);

    }
    static void printNumBoth(int n)
    {
        System.out.println(n);
        if(n==5)
        {
            System.out.println(n);
            return;
        }
        //this is called Tail Recursion
        //as this is the last function call
        printNumBoth(n+1);
        System.out.println(n);

    }
}
