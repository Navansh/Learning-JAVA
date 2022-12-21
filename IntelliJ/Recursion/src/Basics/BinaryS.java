package Basics;

public class BinaryS
{
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 43, 55, 455, 3321, 3322, 3324};
        System.out.println(BinarySearch(arr,9,0,arr.length-1));
    }
  public static int BinarySearch(int[] arr, int target, int start,int end)
    {
        if (start>end)
        {
            //not found the answer
            return -1;
        }
        int middle = start + (end-start/2);
        if (arr[middle]==target)
        {
            return middle;
        }
        if (target<arr[middle])
        {
//            end = middle -1;
            //hence we do another function call for this
            return BinarySearch(arr,target,start,middle-1);
            //as it is a function call and it has a return type hence we have to take what it returns
            // and do something with it
        }

        return BinarySearch(arr,target,middle+1,end);
    }
}
