package Class_3.Polymorphism;

public class Triangle extends Shapes {
    int t = 1;
    public static void main(String[] args) {

    }
}
class DJ extends Triangle{
    int t = 0;
    public static void main(String[] args) {
        Triangle t1 = new DJ();
        System.out.println(t1.t);
    }
    //a class can have 2 or more main methods
//    You can have main methods with different signatures from main(String[])
//    which is called overloading, and the JVM will ignore those main methods.
//    The only way to have two main methods is by having two different classes each with one main method.
//    The name of the class you use to invoke the JVM (e.g. java Class1, java Class2) determines which main
//    method is called.


}
