public class Shadowing
{
    static int x =45;//this will be shadowed at line 8
    public static void main(String[] args)
    {
        System.out.println(x);
        int x =90;
        System.out.println(x);
        x =33;
        System.out.println(x);//all modifications will be done to the local x
        fun();
    }

    static void fun()
    {
        System.out.println(x);
    }
}
