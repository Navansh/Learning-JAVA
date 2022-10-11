class Triangle {
    private double a;
    private double b;
    private double c;
    // Side 1 of Triangle // Side 2 of Triangle // Side 2 of Triangle
// Constructor Method - 1 Used to Create Equilateral Triangle

    public double getA(){
        return this.a;
    }
    Triangle(double side) {
        a = b = c = side;
        displaySides();
    }// End of Constructor

    // Constructor Method - 1 Used to Create Isosceles Triangle
    Triangle(double side1, double side2) {
        a = b = side1;
        c = side2;
        displaySides();
    }// End of Constructor

    // Constructor Method - 3 Used to Create Scalene Triangle
    Triangle(double side1, double side2, double side3) {
        a = side1;
        b = side2;
        c = side3;
        displaySides();
    }

    public void displaySides() {
        System.out.println("Side 1:" + a);
        System.out.println("Side 2:" + b);
        System.out.println("Side 3:" + c);
    }// End of Method }// End of Class

}
/* Driver Class */
class Overloaded_constructors
{
    public static void main(String args[]) {
        Triangle T1 = new Triangle(10);
        Triangle T2 = new Triangle(20, 30);
        Triangle T3 = new Triangle(10,6,8);
    } // End of Method
}// End of class ConstructorDemo// End of Constructor

