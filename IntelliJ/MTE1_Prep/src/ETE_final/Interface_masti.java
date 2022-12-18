package ETE_final;

import org.w3c.dom.ls.LSOutput;

public class Interface_masti implements Sort,Dost
{
    public static void main(String[] args) {

    }
    @Override
    public void show() {

    }

    @Override
    public void display() {

    }
}
interface Sort{
    int x =10;
    void show();
    void display();
    public default void navansh()
    {
        System.out.println("Masti is real");
    }
}
interface Dost{
    int y =10;
    int z =10;
}
