package Class_2;

public class Singleton_Ex {
    private Singleton_Ex() {
        //we create its singleton functionality by restricting the access of the constructor
        //and hence thereby allow only one time usage of constructor to form an object
    }
    private static Singleton_Ex instance;
    //as static so value doesn't depend on object

    public static Singleton_Ex getInstance(){
        //check whether an object is created or not
        //so whether through this function the user can run it several times, but always it will be getting the same instance
        //hence only one object creation
        if (instance == null) {
            instance = new Singleton_Ex();
            //as private constructor so can only be called in this class
        }
        //so only once when the instance is not initialized it will initialize it and from then on, it will just
        //return the previously initialized instance, no matter how many times you call it
        return instance;
    }

    public static void main(String[] args) {
    }

}
