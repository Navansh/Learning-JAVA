package Class_4.Different_Package;

import Class_4.Classy;
import Class_4.Main;

public class Subby extends Classy {
    public static void main(String[] args) {
        Classy c11 = new Classy();
//        int n = c11.all;
        //now even the Classy class itself cannot access the "all" variable cz, protected variables
        //outside the package can only accessed by its subclass object or sub-subclass object and so on.......
        //hence, object of "Subby" can access "all" variable

        Subby c21 = new Subby();
        int nn = c21.all;

        System.out.println(c21 instanceof Classy);
        //checks whether the specified object is an instance of the class you are specifying
    }
}
