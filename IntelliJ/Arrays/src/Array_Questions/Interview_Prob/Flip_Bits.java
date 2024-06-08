package Array_Questions.Interview_Prob;

public class Flip_Bits {
    public static void main(String[] args) {
        //https://www.geeksforgeeks.org/problems/flip-bits0240/1

    }

    public static int maxOnes(int[] a, int n) {
        int count = 0;
        //we'll be using Kadane's Algo
        for (int i = 0; i < a.length; i++) {
            if(a[i] == 0) {
                a[i] = 1;
            } else {
                //this means a[i] is 1
                a[i] = -1;
                //that is loss for us
                //also count the no of 1's in the array
                count++;
            }
        }

        int cSum = 0;
        int oSum = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            if(cSum >= 0) {
                cSum += a[i];
            } else {
                cSum = a[i];
            }

            oSum = Math.max(oSum, cSum);
        }

        if(oSum > 0) {
            //in the case, where there are all 1s in the array, Osum will be negative

            return count + oSum;
        }

        return count;
    }
}
