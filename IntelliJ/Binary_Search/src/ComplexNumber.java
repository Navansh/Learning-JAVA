public class ComplexNumber
{
    private double real;
    private double imag;

    ////Constructors
    ComplexNumber() {
        this.real = 0.0;
        this.imag = 0.0;
    }
    ComplexNumber(double real)
    {
        this.real = real;
        this.imag=0.0;

    }
    ComplexNumber(double real, double imag)
    {
        this.real = real;
        this.imag = imag;
    }

    public double getReal()// accessor class
    //Why not do without accessor class ?
    {
        return this.real;
    }

    //mutator methods
    public void setReal(double real)
    {
        this.real = real;
    }

    public double getImag() //setter methods
    {
        return this.imag;
    }

    public void printValues()
    {
        System.out.println("Real = "+ this.real);
    }
    //this.real can be accesses only within class
    //but this.getreal can be accesses outside class

    public ComplexNumber multiply(ComplexNumber other)
    {
        double r = this.getReal() * other.getReal() - this.getImag() * other.getImag();
        double c = this.imag * other.real + this.real*other.imag;
        ComplexNumber C = new ComplexNumber(r,c);
        return C;
    }//End of Class
    public boolean isEqual(ComplexNumber other)
    {
        return (this.real == other.real && this.imag == other.getImag());
    }
    //implicit parameter
    //without actually passing a parameter we pass a parameter
//    c1.getreal// one parameter is being passed through getreal
    // any object-reference variable 'r' is the implicit parameter to any method which is invoked via 'r'
    //this is always an implicit parameter
    //implicit parameter > explicit parameter we generally return +ve
    //                     <                                    -ve
    //                      =                                       0

    public int compareComplex(ComplexNumber other)
    {
        if(this.real == other.real && this.imag == other.imag) return 0 ;
        else if (this.real > other.real) return 100;
            else return -1;
    }
}
class ComplexTest
{
    public static void main(String[] args)
    {
        ComplexNumber c1 = new ComplexNumber();
        ComplexNumber c2 = new ComplexNumber(0.0,0.0);
        ComplexNumber c3 = new ComplexNumber(2.6666666,2.6666666666666666667);


//        c3.printValues();
        System.out.println(c1.getReal());
//        System.out.println(c2.compareComplex(c3));
    }

    //for using a private variable outside the class we use get(var_name)
    //object variable -> memory allocated when the object created
    //public -> protected -> package pvt (accessible in same package) -> pvt   :Scope of var
    //default is "package pvt" when you don't mention explicitly

//state of an object : variable ki value(attribute value at a (particular point in time)
}
