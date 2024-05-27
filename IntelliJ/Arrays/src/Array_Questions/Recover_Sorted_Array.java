package Array_Questions;

import java.util.Arrays;

public class Recover_Sorted_Array {
    public static void main(String[] args) {
        //https://www.geeksforgeeks.org/sort-an-almost-sorted-array-where-only-two-elements-are-swapped/
        //Given an arr, which is formed by swapping 2 distinct index in a sorted (increasing)
        //order, restore this array back to normal
        int[] arr = {3,6,10,15,12,17,20,33};
        System.out.println(Arrays.toString(restoreArray(arr)));
    }

    public static int[] restoreArray(int[] arr) {
        //given 1 and only 1 index has been swapped with another index
        int index1 = -1;
        int index2 = -1;

        int i = 0;
        while (i + 1 < arr.length) {
            if(arr[i] < arr[i + 1]) {
                //then they are in increasing order
                i++;
            } else {
                //they are not in increasing order
                if(index1 == -1) {
                    //this is the first faulty index
                    index1 = i;
                    i++;
                } else {
                    index2 = i + 1;
                    break;
                }
            }
        }

        //if doing all of this, and still if our index2 == -1, then
        //it means our swapped indices were consecutive one and hence
        //our algo couldn't catch it
        if(index2 == -1) {
            index2 = index1 + 1;
        }

        //swap the indices
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;

        return arr;
    }


}
