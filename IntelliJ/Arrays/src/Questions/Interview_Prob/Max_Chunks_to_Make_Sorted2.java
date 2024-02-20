package Questions.Interview_Prob;

public class Max_Chunks_to_Make_Sorted2 {
    public static void main(String[] args) {
        //https://leetcode.com/problems/max-chunks-to-make-sorted-ii/
        int[] arr = {5,4,3,2,1};
        System.out.println(maxChunksToSorted(arr));
    }

    public static int maxChunksToSorted(int[] arr) {
        //create a maxDigit array
        int[] maxNumber = new int[arr.length];
        int[] minNumber = new int[arr.length];

        maxNumber[0] = arr[0];

        //calculating prefixMax
        for (int i = 1; i < arr.length; i++) {
            maxNumber[i] = Math.max(maxNumber[i - 1], arr[i]);
        }

        //create minNumber
        minNumber[arr.length - 1] = arr[arr.length - 1];

        //calculating suffixMin
        for (int i = arr.length - 2; i >= 0; i--) {
            minNumber[i] = Math.min(minNumber[i + 1], arr[i]);
        }

        int chunks = 0;
        int vars = -1;

        //now run a loop and check 
        for (int i = 0; i < arr.length - 1; i++) {
            if(maxNumber[i] <= minNumber[i + 1]) {
                chunks++;
                vars = i;
            }
        }

        if(vars == -1) {
            return 1;
        }

        //check if the element at the last index is at its correct place or not

        return chunks + 1;
        //+ 1, cz at the end there will be 2 cases, when the last one forms a single
        //chunk : that case is handled here
        //when the last elements forms a chunk with prev ele ; in that case also
        //out loop will give only the chunks which are not going till the last index
        //and we are separately handling single case : ie 5,4,3,2,1

    }


}
