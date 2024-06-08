package Array_Questions.SubArrays;

public class SumofSubarrays {
    public static void main(String[] args) {
        int[] arr = {5,3,-1,8};
        System.out.println(totalSum(arr));
    }

    public static int totalSum(int[] arr) {
        //we need to find occurance for each index and then finally add them all
        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            int start_pt = i + 1;
            int end_pt = arr.length - i;

            int no_of_Occurances = start_pt * end_pt;

            ans += (arr[i] *no_of_Occurances);

        }

        return ans;
    }
}
