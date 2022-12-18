package Maths;

public class Prime_Checker_Range
{
    public static void main(String[] args) {
        int n = 40;
        boolean[] primes = new boolean[n+1];
//        if we put n here and we are considering indexes then we won't get n we'll instead n-1
        Sieve(n,primes);
    }
    //we'll be using the Sieve of Eratosthenes Method
    public static void Sieve(int n,boolean[] primes)
    {
        for (int i = 2; i*i <=n ; i++) {
            //false in array means number is prime
            //true - the number is not prime
            //hence whenever we find a false no make its multiples as true
            if (!primes[i])
            {
                for (int j = 2*i; j <= n; j+=i) {
                    primes[j] = true;
                }
            }
        }
        for (int i = 2; i <=n ; i++) {
            if (!primes[i]){
                System.out.println(i);
            }
        }
    }
}
