package Class_6.Cloning;

public class Human implements Cloneable {
    //this cloneable, even though it doesn't have any abstract function is still necessary to tell the JVM that we are
    //using clone() in the object of type Human, and hence we want to allow this class's object to be cloned
    int age;
    String name;
    int[] arr;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
        this.arr = new int[]{3,4,5};
    }

    public Human(Human other){
        this.age = other.age;
        this.name = other.name;
    }

    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        //this is Shallow Copy
//        return super.clone();
//    }
    protected Object clone() throws CloneNotSupportedException {
        //this is Deep Copy
        Human twin = (Human)super.clone();
        //this is actually shallow copy
        //after doing shallow copy, we do steps to make different object

        //make deep copy
        twin.arr = new int[twin.arr.length];
        for (int i = 0; i < twin.arr.length; i++) {
            twin.arr[i] = this.arr[i];
        }
        return twin;

    }
}
