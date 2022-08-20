import java.util.Arrays;

public class VarArgs
{
    //variable length arguments
    //you pass these whenever you don't know how many inputs you are gonna enter

    public static void main(String[] args) 
    {
        fun(45);
        multiple(45,22,"Kunal","Dk","dd");
        fun(45);

    }

    static void fun(int ...v)
    {
        System.out.println(Arrays.toString(v));
    }
    static void multiple(int a,int b,String ...v)
    {
        System.out.println(Arrays.toString(v));
    }

    static void fun(int v)
    {
        System.out.println(v);
    }
}
