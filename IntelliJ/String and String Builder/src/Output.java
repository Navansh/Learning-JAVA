import java.util.Arrays;

public class Output
{
    public static void main(String[] args)
    {
        System.out.println(56);
        //doing the same thing using Wrapper class
        Integer num = new Integer(56);
        System.out.println(num.toString());

        System.out.println(new int[]{1,2,3,4});//here it just uses the default method of 'toString' to print it
        //which is by using hashcode
        //and some Name @ hashcode

        //but if want to pretty print it we have to specify what do we want to print it as
        //and we specify that by choosing respective class for printing

        System.out.println(Arrays.toString(new int[]{1,2,3,4}));

    }
}
