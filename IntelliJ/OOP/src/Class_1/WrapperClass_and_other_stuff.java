package Class_1;

public class WrapperClass_and_other_stuff {
    public static void main(String[] args) {
        int a = 10;
        Integer num = 10;
        //so this num is created as an object, hence Integer here is a "wrapper class"

        //but, ***** IMP **** if you say create 2 object type integers and then swap them, they will
        //still NOT Swap

        Integer a1 = 10;
        Integer b1 = 20;
        swap(a1,b1);
        System.out.println(a1 + " " + b1);;
        //as the output suggests the vars have not been swapped
        //this is due to Integer object having "final" in its definition

        final A kunal = new A("Dance");
        kunal.name = "This is modifying";
        //can do this as, If an instance variable of a reference type has the final modifier, the value of that instance
        // variable (the reference to an object) will never change—it will always refer to the same object—but the
        // value of the object itself can change.
        //hence, when a non-primtive is final you cannot reassign it like this 👇,
//        kunal = new A("Bear");
        //cannot do this

    }

    private static void swap(Integer a1, Integer b1) {
        Integer temp = a1;
        a1 = b1;
        b1 = temp;
    }

    static class A{
        String name;

        public A(String name) {
            this.name = name;
        }
    }
}
