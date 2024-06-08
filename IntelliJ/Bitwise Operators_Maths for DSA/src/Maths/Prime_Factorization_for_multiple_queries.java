package Maths;

public class Prime_Factorization_for_multiple_queries {
    public static void main(String[] args) {
        int[] arr = {12};
        primeFactorsMultipleQueries(arr, 50);
    }

    public static void primeFactorsMultipleQueries(int[] queries, int n ) {
        //we are given with multiple queries, which have numbers and we have to
        //return the prime factorization of it

        //we first make the index and value array for sieve of erastosthenes approach
        //hence we create the smallest prime factor array till n
        int[] spf = new int[n + 1];

        for (int i = 0; i < spf.length; i++) {
            spf[i] = i;
        }
        
        //now fill it with the smallest prime factors for each number
        for (int i = 2; i*i <= n ; i++) {
            if(spf[i] == i) {
                //it means that this a prime number
                //hence make all its multiples as marked
                for (int j = 2*i; j <= n; j+=i) {
                    //now check if this index is already marked with a smaller prime
                    //number, if yes then we don't rewrite it
                    if(spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }
        
        //now we have the spf array
        //and now we can fulfill any query

        for (int i = 0; i < queries.length; i++) {
            //do prime factorization for every query
            int x = queries[i];
            //for this number we have to do prime factorization

            System.out.println("Doing for the number " + x);

            while (x > 1) {
                //find its least prime factor from the spf array and then print it
                //and then divide the number by it and then repeat
                int smallest_pf = spf[x];
                System.out.print(smallest_pf + " ");
                x = x/smallest_pf;
            }
            System.out.println(" ");
        }

    }
}
