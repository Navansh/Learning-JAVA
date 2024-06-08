import java.util.Arrays;

public class Q_Reverse_array
{
    public static void main(String[] args)
    {
        int[] arr = {1,3,5,7,9,0,11,13};
        reverse(arr);
        System.out.println(Arrays.toString(arr));


    }


    //loop will stop when the start number becomes greater than the end number
    static void swap(int[] arr, int index1, int index2)
    {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    static void reverse(int[] arr)
    {
        //this method works for both odd and even numbered indices arrays
        int start = 0;
        int end = arr.length - 1; // very crucial step as otherwise then end will be out of bound
        while(start<end)
        {
            swap(arr,start,end);
            start++;
            end--;
        }
    }
}
