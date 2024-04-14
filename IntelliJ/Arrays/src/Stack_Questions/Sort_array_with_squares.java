package Stack_Questions;

public class Sort_array_with_squares {
    public static void main(String[] args) {
//https://www.interviewbit.com/problems/sort-array-with-squares/

    }

    public int[] solve(int[] A) {
        int[] arr = new int[A.length];

        for(int i = 0; i < A.length; i++){
            A[i] = A[i]*A[i];
        }

        int i = 0;
        int j = A.length-1;
        int k = arr.length-1;

        while(i<=j){

            if(A[i] > A[j]){

                arr[k] = A[i];
                i++;
                k--;
            }else{
                arr[k] = A[j];
                j--;
                k--;
            }

        }

        return arr;
    }
}
