package Stack_Questions.SubArrays;

public class PrintEachSubarraySum {
    public static void main(String[] args) {
        //print each subarray Sum
        int[] arr = {5,3,-1,8};
//        printSumBruteforce(arr);
        printSumOptimized(arr);

    }

    private static void printSumOptimized(int[] arr) {
        //here we'' use the concept of prefixSum to optimize the calculation
        //of sum between different ranges
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                //calculate the sum between 2 indices start end
                //start : i and end : j
                int sum = 0;
                if(i ==0) {
                    sum = prefixSum[j];
                } else {
                    sum = prefixSum[j] - prefixSum[i - 1];
                }

                System.out.println(sum);
            }
        }

    }

    private static void printSumBruteforce(int[] arr) {
        //use the same technique as to print each subarray
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j ; k++) {
                    sum += arr[k];
                }
                System.out.println(sum);
            }
        }
    }


}
