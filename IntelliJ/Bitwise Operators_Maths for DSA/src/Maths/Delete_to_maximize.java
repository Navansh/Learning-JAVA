package Maths;

public class Delete_to_maximize {
    public static void main(String[] args) {
        int[] arr = {3,16,18,24};
        System.out.println(maxGCD(arr));
    }

    public static int maxGCD(int[] arr) {
//   The maximum Possible GCD after deleting 1 element and we can only delete at max
//   1 element and we have to delete it its compulsory/
        //take the prefix and suffix GCD for the entire array
        int[] prefixGCD = new int[arr.length];
        int[] suffixGCD = new int[arr.length];

        prefixGCD[0] = Math.abs(arr[0]);
        //whenever doing gcd, always try to get gcd in absolute terms only *******
        suffixGCD[arr.length - 1] = Math.abs(arr[arr.length - 1]);

        for (int i = 1; i < arr.length ; i++) {
            prefixGCD[i] = GCD(prefixGCD[i - 1], Math.abs(arr[i]));
        }

        for (int i = arr.length - 2; i >= 0 ; i--) {
            suffixGCD[i] = GCD(suffixGCD[i + 1], Math.abs(arr[i]));
        }

        //now iterate through the array
        int max_gcd = suffixGCD[1];
        //this is when we ignore the first element of the array, hence the gcd is of
        //the remaining elements

        for (int i = 1; i < arr.length - 1 ; i++) {
            //now we find gcd for all other elements ignored, other than 1st and last
            int gcd = GCD(prefixGCD[i - 1], suffixGCD[i + 1]);
            max_gcd = Math.max(max_gcd, gcd);
        }

        max_gcd = Math.max(max_gcd, prefixGCD[arr.length - 2]);
        //in this case we ignore the last element and find the gcd

        return max_gcd;
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
