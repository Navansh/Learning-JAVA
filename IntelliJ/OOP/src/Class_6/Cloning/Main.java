package Class_6.Cloning;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Human kunal = new Human(45,"Do");
//        Human twin = new Human(kunal);
        //doing this we created an object, so this a lot of processing time cz it uses a new keyword
        //so we can do the object cloning using :
        //there is an interface in the java.lang package called cloneable, so we must implement that
        //by the class whose clone we want to create

        Human twin = (Human)kunal.clone();
        //so what is does is creates a shallow copy of the object
        System.out.println(twin);


    }
}
