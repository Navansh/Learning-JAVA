package Class_5.Interface;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Car c1 = new Car();
        CdPlayer cd = new CdPlayer();
        cd.start();
        c1.acc();
        c1.start();
        c1.brake();
        c1.stop();
    }
}
