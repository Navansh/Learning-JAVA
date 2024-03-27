package Question;

public class Sort_partially_sorted_array {
    public static void main(String[] args) {

    }

    public static void sortPartially(int[] arr) {
        //start with the second last index and keep checking

        for (int i = arr.length - 2; i >= 0; i--) {
            if(arr[i] > arr[i + 1]) {
                //then swap both as then the last element is not at its correct place
                swap(arr, i, i + 1);
            } else {
                //if this is not the case, then no need to look ahead, as jth element
                //is already at its correct position
                break;
            }
        }
    }

    public static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
