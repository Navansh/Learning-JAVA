package MTE_2.java;
class A{
    A(int x,int y)
    {
        System.out.println("This is constructor of Class A");
    }
    protected int a =20;
}
class B extends A{
    B(int x,int y)
    {
        super(34,23);
        //you have to add this otherwise compile time error
//      A sub-class constructor must call a parameterized constructor of super-class
        //unparameterized ko bhi call nhi karoge toh bhi kaam chal jayega

//        Note : super() statement must be the first statement in a sub-class constructor

        System.out.println("This is constructor of Class b");
//        private int a =30;
    }
    private int a =30;
    void show()
    {
        int a =50;
        System.out.println("a = "+this.a);
        //b class mein instant variable ko dhoondhega if not found then super class mein
        //dhonndhega and then print
        System.out.println("a = "+a);
        //simple a means iss method ka print karega,
        //method mein nhi hai toh class wala(here b)  usko print karega
        System.out.println("a = "+super.a);
        //directly jo super class mein hoga usko print karega

    }
}
class Masti
{
    public static void main(String[] args) {
       B b1 =new B(33,45);
            b1.show();
    }
}
