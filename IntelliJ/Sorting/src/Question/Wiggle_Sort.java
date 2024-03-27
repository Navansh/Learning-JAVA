package Question;

public class Wiggle_Sort {
    public static void main(String[] args) {
        //NOT an actual sorting algo, this is a ques

        //sort the array such that the odd numbered indices should be greater than their
        //nearest even no indices
    }

    public static void wiggleSort(int[] arr) {
        //check from 0th index
        for (int i = 0; i < arr.length - 1; i++) {
            if(i % 2 == 0) {
                //means i is even
                if(arr[i] <= arr[i + 1]) {
                    continue;
                    //means it satisfies the condition, hence do nothing
                } else {
                    //swap these 2 elements
                    Swap(arr, i, i + 1);
                }
            } else {
                if(arr[i] >= arr[i + 1]) {
                    continue;
                } else {
                    Swap(arr, i , i + 1);
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
