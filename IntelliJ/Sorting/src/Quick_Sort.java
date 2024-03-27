import java.util.Arrays;
import java.util.Random;

public class Quick_Sort {
    public static void main(String[] args) {
        int[] arr = {-13,4,243,4,35,5,9};
        QuickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        Random m = new Random();
        System.out.println(m.nextInt(4,10));
    }

    public static void QuickSort(int[] arr, int start, int end) {

        if(start >= end) {
            //means just one element which is already sorted
            return;
        }

        //first put the pivot at its correct place
        int p = rearrangeSubarray(arr,start,end);

        //now call for the divisions
        QuickSort(arr, start, p - 1);
        QuickSort(arr, p + 1, end);
        //the mid is fixed


    }

    public static int rearrangeArray(int[] arr) {
        //rearrange this arr on the basis of 0th index
        //ref - 0th index is the pivot index
        int p1 = 1;
        int p2 = arr.length - 1;

        while (p1 <= p2) {
            if(arr[p1] <= arr[0]) {
                //equal to element will go on the LHS, given in the problem statement
                p1++;
            } else if(arr[p2] > arr[0]) {
                p2--;
            } else {
                // means both the p1 and p2's elements are not at its correct position
                // means swap p1 and p2
                Swap(arr, p1, p2);
                p1++;
                p2--;
            }
        }

        //once we are outside this loop, it means that p1 and p2 have crossed each other
        //now just swap p2 with arr[0]

        Swap(arr, 0, p2);
        return p2;
        //return the index where you eventually placed the pivot ele

        //done
    }

    public static int rearrangeSubarray(int[] arr, int start, int end) {
        //rearrange this arr from start to end, where pivot is start
        //ref - 0th index is the pivot index
        int p1 = start + 1;
        int p2 = end;

        while (p1 <= p2) {
            if(arr[p1] <= arr[start]) {
                //equal to element will go on the LHS, given in the problem statement
                p1++;
            } else if(arr[p2] > arr[start]) {
                p2--;
            } else {
                // means both the p1 and p2's elements are not at its correct position
                // means swap p1 and p2
                Swap(arr, p1, p2);
                p1++;
                p2--;
            }
        }

        //once we are outside this loop, it means that p1 and p2 have crossed each other
        //now just swap p2 with arr[0]

        Swap(arr, start, p2);
        return p2;
        //return the index where you eventually placed the pivot ele
        //done
    }

    public static void Swap(int[] arr,int first,int second)
    {
        int temp = arr[first];
        arr[first]=arr[second];
        arr[second] = temp;
    }
}
