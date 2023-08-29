package Question;

import java.util.Arrays;

public class Missing_Number {
    //this is for missing number, a ques already done before, but I am doing it again

    public static void main(String[] args) {
        int[] nums = {6,3,5,0,1,2};
        sort(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static void sort(int[] arr ) {
        //each element should be at index = value
        for( int i=0; i <= arr.length - 1; i++ ) {
            int correct_index = i;
            while(arr[i] < arr.length && arr[i] != i) {
                Swap(arr, i, arr[i]);
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
