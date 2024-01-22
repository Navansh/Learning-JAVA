package Questions_and_Concepts_of_Recursions;

public class LC_Power {
    public static void main(String[] args) {
        System.out.println(myPow(2.00, 100));
    }

    public static double myPow(double x, int n) {
        //we'll divide it in n/2 intervals and do the recursion calls

        if (n == 0) {
            return 1;
        }

        if (n == Integer.MIN_VALUE) {
            //handling the min value case ****
            double temp = myPow(x, n / 2);
            return temp * temp;
        }

        // Handling negative powers
        if (n < 0) {
            return 1 / myPow(x, -n);
        }

        // Recursive case for positive n
        double temp = myPow(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            return temp * temp * x;
        }
    }

    public static double myPow2(double x, int n) {
        //doesn't require the handling of min_int-value condition separately
        if (n == 0)
            return 1.0;

        if (n % 2 == 1)
            return x * myPow(x, n - 1);

        if (n % 2 == 0)
            return myPow(x * x, n / 2);

        return 1 / myPow(x, -n);
    }
}
