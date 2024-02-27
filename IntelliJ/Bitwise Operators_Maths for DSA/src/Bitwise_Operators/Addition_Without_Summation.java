package Bitwise_Operators;

public class Addition_Without_Summation {
    public static void main(String[] args) {

    }

    public static int addNumbers(int A, int B) {
        int sum = A-(~B)-1;
        return sum;
    }
}
