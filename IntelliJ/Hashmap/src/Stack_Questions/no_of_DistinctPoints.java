package Stack_Questions;

import java.util.HashSet;

public class no_of_DistinctPoints {
    public static void main(String[] args) {
        int[] x = {2, 1, 3, 2, 2};
        int[] y = {3, 1, 2, 3, 4};
        System.out.println(noOfDistinctPoints(x,y));
    }

    public static int noOfDistinctPoints(int[] x, int[] y) {
        //let the hashing function be 2x + 3y
        //and add that to the hashset and return the size of HashSet
        HashSet<Integer> unique = new HashSet<>();

        for(int i = 0; i < x.length; i++) {
            int temp = 2*x[i] + 3*y[i];
            unique.add(temp);
        }

        return unique.size();
    }
}
