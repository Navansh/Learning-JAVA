package Maths;

public class Newton_SQRT
{
    public static void main(String[] args) {
        System.out.println(FindSqrt(40));
    }
    static double FindSqrt(double n){
        double x = n;
        double root1;
        while (true)
        {
            root1 = 0.5*(x + (n/x));

            //to break out from the loop
            if (Math.abs(root1- x) < 0.005)
            {
                break;
            }
            x = root1;
        }

        return root1;
    }
}
