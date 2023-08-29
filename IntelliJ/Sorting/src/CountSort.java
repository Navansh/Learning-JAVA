import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] arr = {11,45,22,5,99,1,2,3,6,99};
    //    basicCountSort(arr);
        stableCountSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void stableCountSort(int[] arr) {
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
        int[] count = new int[max + 1];
        //by default all the values are 0

        //creating the freq array now
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        //now we need to create the pre-fix array from this frequency array
        //we will update the count array only
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }

        //as using the arr, we are going to construct the output array, hence we create a
        //new Output array,
        int[] output = new int[arr.length];

        //find the index of each element in the original Array and put it in the O/P array
        for (int i = arr.length -1 ; i >= 0; i--) {
            //we will start from back so as to maintain stability
            int index = count[arr[i]] - 1;
            output[index] = arr[i];
            count[arr[i]]--;
        }

        //now as this method doesn't return any value so just copy the O/P array to the OG Array
        System.arraycopy(output, 0, arr, 0, arr.length);


    }
    public static void basicCountSort(int[] arr) {

        //***This is not Stable
        //steps :
        //1)define the max range of nos you are working with
        //hence find the largest element
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        //2) create the freq/count array of size = max + 1( cz 0 se start), where max is the maximum number
        int[] count = new int[max + 1];
        //by default all the values are 0
        
        //creating the freq array now
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        //3) sort the original array using this freq array / count array
        //modifying the OG array by placing the given number of elements, their frequency
        //no of times
        int k = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                arr[k] = i;
                k++;

            }
        }
        
    }
}
