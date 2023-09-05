package Basics;

public class Palindrome_or_Not {
    //here we are talking about numbers
    static int reverseMethod2(int n) {
        //sometimes you might need some additional variables in the argument
        // in that case make a helper function
        int digits = (int)(Math.log10(n) + 1);
        //as this needs to be calculated every time the function is called
        return helper(n,digits);
    }

    private static int helper(int n, int digits) {
        if(n%10==n) return n;

        int rem = n%10;

        return (int)(rem * Math.pow(10, digits - 1) + reverseMethod2(n/10));
    }

    public static boolean PalindromeOrNot(int n) {
        return n == reverseMethod2(n);
    }
    public static void main(String[] args) {
        System.out.println(PalindromeOrNot(123321));
    }
}
