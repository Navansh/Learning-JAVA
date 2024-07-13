package Maths;

public class Find_factorial_n_mod {
    public static void main(String[] args) {
        //given n ,find factorial n % (10^9 + 7)
    }

    public static long findFact(int n) {
        //given n < 10^4
        int mod = 1000000007;

        long ans = 1;
        for (int i = 1; i < n; i++) {
            ans = ((ans % mod) * (i % mod)) % mod;
            //whenever ans var goes more than int, this mod
            //keeps it in the int range
        }

        return ans;
    }
}
