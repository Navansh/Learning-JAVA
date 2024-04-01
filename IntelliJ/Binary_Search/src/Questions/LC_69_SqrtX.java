package Questions;

public class LC_69_SqrtX {
//    https://leetcode.com/problems/sqrtx/description/
    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }

    public static int mySqrt(int n) {
//        given a number, we need to find its sqrt
        //we take numbers from n and find its sqrt

        //now search for sqrt in this
        int low = 0;
        int high = n;
        int ans = 0;

        //we don't really need to create an array for this

        while (low <= high) {

            int mid = low + (high - low)/2;

            if(mid*mid == n) {
                return mid;
            } else if(mid * mid< n) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}
