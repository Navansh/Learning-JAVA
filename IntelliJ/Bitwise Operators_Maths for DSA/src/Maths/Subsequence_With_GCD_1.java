package Maths;

public class Subsequence_With_GCD_1 {
    public static void main(String[] args) {

    }

    public boolean GCDSubsequence(int[] arr) {
        //Output true if there exists a subsequence with GCD 1 else Output false.
        //sol : gcd for a subsequence can only be 1, if the GCD of the entire array is 1

        int ans = Math.abs(arr[0]);

        for (int i = 1; i < arr.length ; i++) {
            ans = GCD(ans, Math.abs(arr[i]));
        }

        return ans == 1;
    }

    static int GCD(int a,int b)
    {
        if (a==0)
        {
            return b;
        }
        return GCD(b%a,a);
    }
}
