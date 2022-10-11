package Questions;

public class Rotation_Count_Rotated_Array
{
    public static void main(String[] args)
    {
        int[] arr = {6,7,1,2,3,4,5};
        if (findPivot(arr)==-1)
        {
            System.out.println("The array is not rotated");
        }
        int rotations = findPivot(arr) + 1;
        System.out.println("The no of times the array is rotated is : "+rotations);
    }
    public static int findPivot(int[] arr)
    {
        int start = 0;
        int end = arr.length - 1;

        //4 cases over here
        while(start<=end)
        {
            int middle = start + (end - start)/2;
            //if first condition is false it won't even check for the next condition
            if ( middle<end && arr[middle]>arr[middle+1]) //this condition is very important as it will ensure that mid+1
            //doesn't go out of bounds
            {
                return middle;
            }
            if (middle > start && arr[middle]<arr[middle-1] )//same here so that mid -1 doesn't go out of bound
            {
                return (middle -1);
            }
            if (arr[start]>=arr[middle])
            {
                end = middle-1;
            }
            else
            {
                start = middle + 1;
            }
        }
        return -1;//when element not found
    }
    public static int findPivotwithDuplicates(int[] arr)
    {
        int start = 0;
        int end = arr.length - 1;

        //4 cases over here\
        while(start<=end)
        {
            int middle = start + (end - start)/2;
            //if first condition is false it won't even check for the next condition
            if ( middle<end && arr[middle]>arr[middle+1]) //this condition is very important as it will ensure that mid+1
            //doesn't go out of bounds
            {
                return middle;
            }
            if (middle > start && arr[middle]<arr[middle-1] )//same here so that mid -1 doesn't go out of bound
            {
                return (middle -1);
            }
//            if (arr[start]>arr[middle])
//            {
//                end = middle-1;
//            }
//            else
//            {
//                start = middle + 1;
//            }
            //this above condition will be only different as maybe start mid and end will be same
            //then this condition will fail
            //hence if elements at start, middle and end are equal then skip start and end

            if (arr[start]==arr[middle]&&arr[middle]==arr[end])
            {
                //skip the duplicates

                //but what if these elements at start and end were the pivots?
                //hence check if start and end are pivots
                if (start>middle && arr[start]>arr[start+1])
                {
                    //then start will the pivot
                    return start;
                }
                start++;
                if (end>middle && arr[end]>arr[end-1])
                {
                    //then end will the pivot
                    return end;
                }

                end--;
            }
        }
        return -1;//when element not found
    }
}
