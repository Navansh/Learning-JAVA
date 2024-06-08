package Question;

public class Inversion_Count {
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    //https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
    public static void main(String[] args) {

    }
    static long ans;
    static long inversionCount(long arr[], long N)
    {
        ans = 0;
        mergeSort(arr,0,arr.length-1);
        return ans;
    }

    static void mergeSort(long arr[], int l, int r)
    {
        //code here
        if(l==r){
            return;
        }
        int m = (l+r)/2;
        mergeSort(arr,l,m);
        mergeSort(arr,m+1,r);

        merge(arr,l,m,r);
    }

    static void merge(long arr[], int l, int m, int r)
    {
        // Your code here
        long[] temp = new long[r-l+1];
        int p1 =l;
        int p2 = m+1;
        int p3 = 0;
        while(p1<=m && p2<=r){
            if(arr[p1] <= arr[p2]){
                temp[p3] = arr[p1];
                p1++;
                p3++;
            }else{
                ans += (m-p1+1);
                //this ^^ is the step when we create the ans
                temp[p3] = arr[p2];
                p2++;
                p3++;
            }
        }

        while(p1<=m){
            temp[p3] = arr[p1];
            p1++;
            p3++;
        }

        while(p2 <= r){
            temp[p3] = arr[p2];
            p2++;
            p3++;
        }

        int i=l;
        int j = 0;

        while(j < temp.length){
            //copying the temp array into the Original array
            arr[i] = temp[j];
            i++;
            j++;
        }

    }

}
