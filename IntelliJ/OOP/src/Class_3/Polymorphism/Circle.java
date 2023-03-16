package Class_3.Polymorphism;

public class Circle extends Shapes {
    @Override //simply an annotation or a check that tells this method is being overriden by its sub-class(of Shapes) methods
    public void area(){
        System.out.println("This is area of Circle");
    }
//    @Override
    static void doit(){
        System.out.println("It has overriden the static method from the parent class ");
    }

}
