package Maths;

public class Smallest_Prime_Factor {
    public static void main(String[] args) {

    }

    public int[] leastPrimeFactor(int n) {
        //form the integer and fill it with the values of its indexes
        //hence 0-> 0, 1-> 1 etc....
        int[] arr = new int[n + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        //now skip through 0 and 1 and start through 2
        for (int i = 2; i*i <= n; i++) {
            //now check if the current value of the ele is equal to its index
            //if yes then its prime
            if(arr[i] == i) {
                //now for this, make all the multiples of it as i
                //hence making it their smallest prime factor
                for (int j = 2*i; j <= n ; j+= i) {
                    //now here if already another smaller number has set itself
                    //as its prime number, then let the least ( means which is
                    //already set be the ans, and don't change it
                    //like 7 will try to change 42, which already has 2 in its place
                    //and for that our above condition arr[i] == i will also be true
                    if(arr[j] == j) {
                        arr[j] = i;
                    }
                }
            }
        }

        return arr;
    }
}
