package Questions.Interview_Prob;

public class Max_Chunks_to_make_Sorted {
    public static void main(String[] args) {
        int[] arr = {1,0,2,3,4};
        System.out.println(maxChunksToSorted(arr));
    }

    public static int maxChunksToSorted(int[] arr) {
        //my Approach
        //as the elements in the array are from 0 to n - 1. they will perfectly align
        //with the indices of the array
        //so to create maximum no of chunks \
        //we first start with the first letter and see if it is in its correct place
        //if it is then chunk++
        //else we go to till the place according to the value of int
        //and in between that if another digit comes that is even bigger than that
        //then we go till that place and create a chunk

        int length = arr.length - 1;
        int start = 0;
        int chunks = 0;

        while(start <= length) {
            //check if it the element at 0 is at its correct index
            if(arr[start] == start) {
                chunks++;
                start++;
            } else {
                //move till the position specified
                int index_togo = arr[start];
                while(start <= index_togo) {
                    if(arr[start] > index_togo) {
                        index_togo = arr[start];
                    }
                    start++;
                }
                chunks++;
            }
        }

        return chunks;
    }

    public static int maxChunksToSortedAnotherWay(int[] arr) {
        //This is another way, same core thinking, but different approach
        //as the elements in the array are from 0 to n - 1. they will perfectly align
        //with the indices of the array
        //so to create maximum no of chunks \
        //we first start with the first letter and see if it is in its correct place
        //if it is then chunk++
        //else we go to till the place according to the value of int
        //and in between that if another digit comes that is even bigger than that
        //then we go till that place and create a chunk

        int max_till_now = Integer.MIN_VALUE;
        int chunks = 0;

        for (int i = 0; i < arr.length; i++) {
            max_till_now = Math.max(max_till_now, arr[i]);

            if(i == max_till_now) {
                chunks++;
            }
        }

        return chunks;
    }
}
