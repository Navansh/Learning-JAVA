package Class_2;

public class StaticBlockEx {
    static int a = 4;
    static int b;

    static {
        //this block will only run once, when the first object is created i.e. when the class is loaded for the first time
        System.out.println("I am in static block");
        b = a*5;
    }
    public static void main(String[] args) {
        StaticBlockEx obj = new StaticBlockEx();
        System.out.println(StaticBlockEx.a + " " + StaticBlockEx.b);

        StaticBlockEx.b += 3;
        System.out.println(StaticBlockEx.a + " " + StaticBlockEx.b);


        StaticBlockEx pbj = new StaticBlockEx();
        //but when this object was created then the staticBlock didn't run, it ran only on the first creation of the
        //object of this class
        System.out.println(StaticBlockEx.a + " " + StaticBlockEx.b);

    }
}
