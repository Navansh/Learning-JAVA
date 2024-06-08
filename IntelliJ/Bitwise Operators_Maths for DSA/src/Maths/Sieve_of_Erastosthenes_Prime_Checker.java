package Maths;

public class Sieve_of_Erastosthenes_Prime_Checker
{
    public static void main(String[] args) {
        int n = 400000;
        boolean[] primes = new boolean[n+1];
//        if we put n here and we are considering indexes then we won't get n we'll instead n-1
        //or simply as we want nth index in the array, hence size of array should be n+1

        Sieve(n,primes);
    }
    //we'll be using the Sieve of Eratosthenes Method
    public static void Sieve(int n,boolean[] primes)
    {
        for (int i = 2; i*i <=n ; i++) {
            //false in array means number is prime
            //true means - the number is not prime
            //hence whenever we find a false no. make its multiples as true
            if (!primes[i]) {
                //means this is a prime number, so mark all its multiples as true
                //hence they're not prime
                for (int j = i*i; j <= n; j+=i) {
                    //can also start from 2*i, but that will anyways be crossed out
                    //or in our case marked true,
                    // so just to save some iterations
                    //we start from i*i which will always give us iterations that
                    //are marked false and then we mark them true
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
