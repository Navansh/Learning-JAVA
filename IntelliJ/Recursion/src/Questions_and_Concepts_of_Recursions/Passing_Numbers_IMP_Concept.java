package Questions_and_Concepts_of_Recursions;

public class Passing_Numbers_IMP_Concept
{
    public static void main(String[] args) {
        fun(5);
    }
    static void fun(int n)
    {
        if (n==0)
        {
            return;
        }
        System.out.println(n);
        //passing n-- will result in Stack Overflow - Concept in Copy
//        fun(n--);
        fun(--n);
    }

}
