package Basics;

public class Reverse_a_No {

    static int sum = 0;
    static void reverseMethod1(int n){
        if(n==0){
            return;
        }
        int rem = n%10;
        sum = sum*10 + rem;
        reverseMethod1(n/10);
    }

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

    public static void main(String[] args) {
        //reverseMethod1(1523);
        int calc = reverseMethod2(1523);
        System.out.println(calc);
    }
}
