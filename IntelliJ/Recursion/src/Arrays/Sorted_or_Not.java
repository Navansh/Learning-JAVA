package Arrays;

import java.util.Arrays;

public class Sorted_or_Not {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
//        System.out.println(sotted(arr,0));
        change(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static boolean sotted(int[] arr,int index)
    {
        //returns true or false based upon if the array passes is sorted or not
        //base condition
        if (index== arr.length-1)
        {
            return true;
        }
        return (arr[index]<arr[index+1]) && sotted(arr,index+1);
    }
    static void change(int[] arr)
    {
        arr[0] = -1;
    }
}
