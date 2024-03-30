package Questions.Two_Pointers;

import java.util.Arrays;

public class Sort_0_and_1 {
    public static void main(String[] args) {
        int[] arr = {1,0,1,1,1,0,0,0};
        sort01(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort01(int[] arr) {
        //we'll use the Dutch National Flag Algo
        //to sort 0 and 1 we'll need 2 pointers
        //one to differentiate between the regions of 0 and 1 and one to keep
        //note on the unknown area of arr
        int i = 0;
        int j = 0;
        int n = arr.length - 1;

        while (j <= n) {
            if(arr[j] == 0) {
                Swap(arr, i ,j);
                i++;
                j++;
            } else {
                j++;
            }
        }

    }

    public static void Swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
