import java.util.Arrays;

public class Radix_Sort {
    public static void RadixSort(int[] arr) {
        //call the count sorting d times ( where d is the maximum number of digits present
        // in a number in the array)
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        //apply counting sort to sort elements based on the place value
        for (int place = 1; max/place > 0 ; place *= 10) {
            stableCountSort(arr, place);
        }
    }
    public static void stableCountSort(int[] arr, int place) {
        //This is Stable Sorting Algo

        //1)define the max range of nos you are working with
        //hence find the largest element
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        //2) create the freq/count array of size = max + 1( cz 0 se start), where max is the maximum number
        int[] count = new int[10];
        //as we just want indices from 0 to 9

        //creating the freq array now, which will be according to the place which we are
        //currently sorting for
        for (int i = 0; i < arr.length; i++) {
            int index = (arr[i]/ place ) % 10;
            count[index]++;
        }

        //now we need to create the prefix array from this frequency array
        //we will update the count array only
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }

        //as using the arr, we are going to construct the output array, hence we create a
        //new Output array,
        int[] output = new int[arr.length];

        //find the index of each element in the original Array and put it in the O/P array
        //here index refers to the digit at the specific place ( place -> ones, tens, ...)
        for (int i = arr.length -1 ; i >= 0; i--) {
            //we will start from back so as to maintain stability
            int digit_place = (arr[i]/place) % 10;
            int index = count[digit_place] - 1;
            output[index] = arr[i];
            count[digit_place]--;
        }

        //now as this method doesn't return any value so just copy the O/P array to the OG Array
        System.arraycopy(output, 0, arr, 0, arr.length);


    }
    public static void main(String[] args) {
        int[] arr = {1,55,66,7,49,88,7,99,145};
        RadixSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
