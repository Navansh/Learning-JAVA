package BS_Questions;

public class Floor_question_Approach_2
{
    public static void main(String[] args) {
         /*
        in this order of ascending and descending isn't given in the question
        and you yourself have to figure it out
        */
//        int [] arr = {90,90,90,87,75,18,15,13,2,1};
        int[] arr={1,4,12,14,34,55,65,78,85,333};
        System.out.println(BinarySearch(arr,15));
        System.out.println(findFloor(arr,15));
        System.out.println(findFloor2(arr,15));
    }

    public static int findFloor(int[] arr, int target) {
        //finding floor means to find the greatest value smaller than equal to target
        //this sol works only for ascending sorted array

        int low = 0;
        int high = arr.length - 1;

        int ans = Integer.MIN_VALUE;


        while ( low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] == target) {
                return target;
            } else if (arr[mid] < target) {
                ans = arr[mid];
                //as this is anyways smaller (means isse chhota nhi milega )
                // toh we keep it as an answer
                //which we'll verify in further iterations of the code

                //now discard left and search towards right
                low = mid + 1;

            } else {
                high = mid - 1;
            }
        }

        return ans;
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

    public static int findFloor2(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1; //imp : -1 karna


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

            if (arr[middle]>target) {
                end = middle -1;
            }
            else {
                start = middle + 1;
            }
        }
        return arr[end];
    }
}
