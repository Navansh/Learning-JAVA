package BS_Questions.Unsorted_Array;

public class LC_162_Find_Peak_Ele {
    public static void main(String[] args) {
//        https://leetcode.com/problems/find-peak-element/description/
    }

    public static int findPeakElement(int[] arr) {

        if(arr.length <= 1) {
            return 0;
            //0 is the index
        }

        //we check for 0th and last ele
        if(arr[0] > arr[1]) {
            //then this is the ans
            return 0;
        }

        if(arr[arr.length - 1] > arr[arr.length - 2]) {
            //this is an ans
            return arr.length - 1;
        }

        //now check for all remaining indices
        int low = 1;
        int high = arr.length - 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            //now we check between mid and mid - 1 or between its neighbours
            if(arr[mid] < arr[mid - 1]) {
                //left neighbour bigger
                //means the left portion is bigger, so we need to go towards RHS
                //and we discard LHS
                high = mid - 1;
            } else if(arr[mid] < arr[mid + 1]) {
                //right neighbour bigger
                //move towards RHS and discard LHS
                low = mid + 1;
            } else {
                //when these both conditions are not true then by default we found the ans
                //which means neither the left nor the right neighbour is bigger
                //which means arr[mid] is bigger which is our ans
                return mid;
            }
        }

        return -1;
    }
}
