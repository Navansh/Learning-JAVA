package Maths;

public class Binary_Search_SQRT
{
    public static void main(String[] args) {
        int n = 48;
        int p = 3;
        //means precision upto 3 decimal places
        System.out.printf("%.3f",sqrt(n,p));
        //printing using placeholder
    }
    static double sqrt(int n,int p)
    {
        //O(n) = log n;
        int start = 0;
        int end = n;

        double root = 0.0;

        while (start<=end)
        {
            //process to find sqrt for perfect sqrt nos
            int mid = start + (end-start)/2;
            if (mid*mid==n)
            {
                return mid;
            }
            else if (mid*mid> n)
            {
                end = mid -1;
            }
            else start = mid + 1;
        }

        //process to find the decimal places sqrt for the non-perfect sqrt nos
        double incrementer = 0.1;
        for (int i = 0; i < p; i++) {
            while (root*root<=n)
            {
                root += incrementer;
            }
            //now as this loop is broken means that root*root > n and that too by incremented value, hence to get
            //actual value of root we do
            root -=incrementer;
            //now we are done for 1 decimal place, now
            incrementer /= 10;
            // for it to increment to say 0.01 etc...
        }

        return root;
    }
}
