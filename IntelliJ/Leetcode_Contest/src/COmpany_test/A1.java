package COmpany_test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class A1 {

    public static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    public static void vout(List<Long> v) {
        for (long x : v)
            System.out.print(x + " ");
        System.out.println();
    }


    public static void vin(List<Long> v, int n) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            long x = scanner.nextLong();
            v.add(x);
        }
        scanner.close();
    }

    public static final long MOD = 1000000007;

    public static long rec(long n) {
        if (n == 0 || n == 1) {
            return n;
        }

        long a = n / 2, b = n / 3, c = n / 4;

        if (a + b + c < n)
            return n;

        return rec(a) + rec(b) + rec(c);
    }

    public static void solve() {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long ans = rec(n);
        System.out.println(ans);
        scanner.close();
    }

    public static void main(String[] args) {
        solve();
    }

}

