package Class_6.Cloning;

import java.util.Arrays;

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
        System.out.println(twin.age + " " + twin.name);
        System.out.println(Arrays.toString(twin.arr));

//        twin.arr[0] = 100;
//        System.out.println(Arrays.toString(kunal.arr));
        //here modifying twin.arr(the kunal's clone), changes kunal.arr also
        //this is called Shallow Copy

        //now, we have commented the clone method for shallow copy and now run the clone method made for deep copy
        twin.arr[0] = 100;
        System.out.println(Arrays.toString(kunal.arr));
        System.out.println(Arrays.toString(twin.arr));
        //here changing the twin doesn't change the content of kunal.arr





    }
}
