package Questions.Two_Pointers;

public class Sort_0_1_and_2 {
    public static void main(String[] args) {
        //https://www.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1
    }

    public static void sort012(int[] a, int n) {
        //using the Algorithm known as Dutch National Flag
        int i = 0, j = 0;
        int k = a.length - 1;

        while (j <= k) {
            if(a[j] == 0) {
                Swap(a,i,j);
                i++;
                j++;
            } else if(a[j] == 1) {
                j++;
            } else {
                Swap(a,j,k);
                k--;
            }
        }

    }

    public static void Swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }


}
