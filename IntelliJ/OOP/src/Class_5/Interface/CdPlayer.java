package Class_5.Interface;

public class CdPlayer implements Media{
    //

    @Override
    public void start() {
        System.out.println("Starting Music");
    }

    @Override
    public void stop() {
        System.out.println("Stopping Music");

    }
    //for interface to interface inheritance use extends keyword
}
