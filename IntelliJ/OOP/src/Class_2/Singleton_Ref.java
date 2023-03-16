package Class_2;

public class Singleton_Ref {
    public static void main(String[] args) {
        Singleton_Ex obj = Singleton_Ex.getInstance();
        Singleton_Ex obj2 = Singleton_Ex.getInstance();
        Singleton_Ex obj3 = Singleton_Ex.getInstance();

        //all these object will get the same instance, and hence all these ref vars are pointing to one single object
        //we can verify this by debugging it

    }
}
