import javax.sound.midi.Soundbank;
import java.util.Arrays;

public class Insertion_Sort
{
    public static void main(String[] args)
    {
//        int[] arr = {1,2,4,5,4,-1,0};
        int[] arr = {1,536,43534,452,2,3,4 };
         InsertionSort2(arr);
//         Arrays.sort(arr);


        System.out.println(Arrays.toString(arr));

    }

    public static void InsertionSort2(int[] arr) {
        //can also be done this way, when we do
        for (int i = 1; i < arr.length; i++) {
            //we don't need to do it for i = 0 as that is already sorted
            //do the insertion step
            for (int j = i - 1; j >= 0 ; j--) {
                if(arr[j] > arr[j + 1]) {
                    //swap them
                    Swap(arr, j, j + 1);
                } else {
                    break;
                }
            }
        }
    }

    public static void InsertionSort(int[] arr)
    {
        for (int i = 0; i < arr.length - 1 ; i++)
        {
            for (int j = i+1 ; j > 0 ; j--)
            {
                if (arr[j]<arr[j-1])
                {
                    Swap(arr,j,j-1);
                } else
                {
                    break;
                }
            }
        }
    }

    public static void Swap(int[] arr,int first,int second)
    {
        int temp = arr[first];
        arr[first]=arr[second];
        arr[second] = temp;
    }
}
