package Array_Questions.SubArrays;

public class PrintAllSubarrays {
    public static void main(String[] args) {
        int[] arr = {5,3,-1,8};
        printSubarray(arr);
    }

    private static void printSubarray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <= j ; k++) {
                    System.out.print(arr[k] + ",");
                }
                System.out.println(" ");
            }
        }
    }


}
