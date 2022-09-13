package Questions;

public class Floor_question_Approach_2
{
    public static void main(String[] args) {
         /*
        in this order of ascending and descending isn't given in the question
        and you yourself have to figure it out
        */
        int [] arr = {90,90,90,87,75,18,15,13,2,1};
//        int[] arr={1,4,12,14,34,55,65,78,85,333};
        System.out.println(BinarySearch(arr,14));
    }
    public static int BinarySearch(int[] arr, int target)
    {
        int start = 0;
        int end = arr.length - 1; //imp : -1 karna

        //firstly finding whether the array is ascending or descending sorted
        boolean isAscending = arr[start] < arr[end];

        while(start<=end)
        {
            //find the middle element
//            int middle = (start+end)/2;
            /* might be possible that (start+ end) exceeds the range of int in JAVA
             * hence it may give you some error
             * Hence a better way to find mid will be */
            int middle = start + (end - start)/2;
            //common for both :
            if(arr[middle]==target)
            {
                //ans found
                return arr[middle];
            }

            //different :
            if(isAscending)
            {
                if (arr[middle]>target)
                {
                    end = middle -1;
                }
                else
                {
                    start = middle + 1;
                }
            }
            else {
                if (arr[middle]<target)
                {
                    end = middle -1;
                }
                else
                {
                    start = middle + 1;
                }

            }

        }
        return arr[end];

    }
}
