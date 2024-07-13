package Maths;

public class Arr_mod_p {
    public static void main(String[] args) {

    }

    public static long findMod(int[] arr, int p) {
        //given a number in array format
        //return arr[] % p or number % p

        //Constraint : 1 <= n <= 10^5

        long num = 0;
        int place_value = 1;
        //this is the place value of the last digit

        for (int i = arr.length - 1; i >= 0 ; i--) {
            num = (( num % p ) + ((long) (arr[i] % p) * (place_value % p) % p ) % p);
            place_value =  ( (place_value % p) * (10 % p ) ) % p ;
        }

        return num;
        //now we don't need to do mod here
    }
}
