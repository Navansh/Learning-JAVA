package Maths;

public class GCD_of_an_Arr {
    public static void main(String[] args) {
        int[] arr = {4,10,12,5};
        System.out.println(GCDArr(arr));
    }

    public static int GCDArr(int[] arr) {
        int ans = Math.abs(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            //calculate gcd with the 1st item and store it
            ans = GCD(ans, Math.abs(arr[i]));
            //as the gcd of negative no is also positive anyways
        }

        return ans;

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
