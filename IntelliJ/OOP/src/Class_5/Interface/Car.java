package Class_5.Interface;

public class Car implements Engine,Brake{

    @Override
    public void brake() {
        System.out.println("I brake like a normal car");
    }

    @Override
    public void start() {
        //NOTE there were 2 starts in the interfaces it implemented but because we are overriding
        //them anyways so we don't need to worry about which one is being called
        System.out.println("I start like a normal car");

    }

    @Override
    public void stop() {
        System.out.println("I stop like a normal car");

    }

    @Override
    public void acc() {
        System.out.println("I accelerate like a normal car");

    }
}
