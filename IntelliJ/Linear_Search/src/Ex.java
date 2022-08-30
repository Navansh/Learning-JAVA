public class Ex
{
    public static void main(String[] args)
    {
        //
        int[] arr = {45,33,33,2,11,2324242,4,4,24,4,24,24,24,1224,34,35,53,4,23,13,113,42,};
        int i = Search(arr,345);
        System.out.println(i);

    }
    //search int the array: return the index if item found
    //otherwise if item not found return -1
    //edge cases
    // what if there is repetition of the element we need to find then we return the first instance
    //of the element in the array
    static int Search(int[] arr, int target)
    {
        if (arr.length==0){
            return -1;
        }

        else
        {
            for (int i = 0; i < arr.length; i++)
            {

                if (target == arr[i]) {
                    return i;
                }
            }

            return -1;
        }
    }
}
