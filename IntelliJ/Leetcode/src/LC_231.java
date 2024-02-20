public class LC_231 {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(2097153));
    }
    public boolean isPowerOfTwoWorking(int n) {
        return n > 0 && (n & n - 1) == 0;
    }
    public static boolean isPowerOfTwo(int n) {
        //Currently, non working*****
        double result = (float) logB(n, 2);

        double resultant = Math.floor(result);
        resultant = (double) resultant;
        String a =  Double.toString(resultant);
        String b =  Double.toString(result);

        return a.equals(b);
    }

    public static double logB(double number, double custom_base) {
        // a is value and b is base
        double result = (Math.log(number) / Math.log(custom_base));
        return result;
    }
}
