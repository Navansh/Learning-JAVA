package Class_5.Interface;

public interface Brake {
    void brake();
    //static interface methods should always have a body
    static void brakeHard(){
        System.out.println("I haved braked");
    }
}
