package Bitwise_Operators;

public class Max_AND_Pair {
    public static void main(String[] args) {
        int[] arr = {21,18,24,17,16};
        System.out.println(maxANDPair(arr));
    }

    public static int maxANDPair(int[] arr) {
        //travel on the leftmost bit (MSB) and then remove that are not 1, if their
        //count is greater than 2, otherwise move forward
        for (int i = 31; i >= 0 ; i--) {
            //starting from 31, as there are 32 bits in integer, so from 0 - 31
            //as we are checking MSB, we start from leftmost bit
            int count = 0;

            for (int j = 0; j < arr.length; j++) {
                if(checkBit(arr[j],i)) {
                    //hence we are checking the ith bit of jth element of the array
                    //hence the bit is 1
                    count++;
                }
            }

            //now check how many set bits we have
            if(count >= 2) {
                //will run on equal to 2 also, as we want to remove all other ele
                //other than these 2
                //start removing all the elements that have the ith bit as 0
                for (int j = 0; j < arr.length; j++) {
                    if(!checkBit(arr[j], i)) {
                        //means that bit is 0
                        //here as we have array, so we can't just remove elements
                        //so we make them 0
                        arr[j] = 0;
                        //making 0, means now every bit of the jth element is 0
                        //hence it will not participate in counting now
                    }
                }
            }
        }

        //now for the ans. take the AND of any 2 non zero elements
        //can't do this directly, so we find out those 2 indexes, whose we want to take
        //AND of

        int idx_1 = -1;
        int idx_2 = -1;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > 0 && idx_1== -1) {
                //== -1, ensures that this is the first index that satisfies this
                //as it is given that all are positive elements
                idx_1 = i;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > 0 && idx_1 != i) {
                //as it is given that all are positive elements
                idx_2 = i;
            }
        }

        return arr[idx_1] & arr[idx_2];
    }

    public static boolean checkBit(int ele, int position) {
        return ((ele >> position) & 1) == 1;
    }
}
