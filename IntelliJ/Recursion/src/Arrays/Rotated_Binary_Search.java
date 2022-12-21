package Arrays;

public class Rotated_Binary_Search
{
    public static void main(String[] args) {
        int[] arr = {5,6,1,2,3,4};
        System.out.println(Search(arr,11,0,arr.length-1));
    }
    static int Search(int[] arr, int target,int start, int end)
    {
        if (start>end)
        {
            return -1;
        }
        int mid = start + (end-start)/2;
        if (arr[mid]==target)
        {
            return mid;
        }
        if (arr[start]<=arr[mid]) {
            //means the first half is sorted, now there are 2 cases whether the key will lie
            // in the first half or not
            if (target >= arr[start] && target <= arr[mid]) {
                return Search(arr, target, start, mid - 1);
            } else return Search(arr, target, mid + 1, end);
        }

        //this will hit when arr[s]>arr[mid]
            if (target>=arr[mid]&&target<=arr[end])
            {
                return Search(arr,target,mid+1,end);
            }
            else return Search(arr,target,start,mid-1);

    }
}
