package Class_5;

public abstract class Son extends Parent {
    //abstract class extending another abstract class
    String name;
    @Override
    void career(String name) {
        this.name = name;
    }
    abstract void coker(String namee);
}
