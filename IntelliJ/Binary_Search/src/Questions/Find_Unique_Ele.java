package Questions;

public class Find_Unique_Ele {
    public static void main(String[] args) {
        //Approach 1 : do XOR and find it
        //Approach 2 : using Binary Search
        int[] arr = {20,4,4,1,1,9,9,11,11,7,7,3,3,5,5};
        System.out.println(findUniqueElement(arr));
    }

    public static int findUniqueElement(int[] arr) {
        //all elements in this array are sorted and occur twice one after the other
        //except one element, find that unique element

        //as in the entire code, we're doing mid + 1 and mid - 1, so to handle
        // array out of bounds erxception we handle 1st and last case seperately

        //checking if ele at 0th index is our answer
        if(arr[0] != arr[1]) {
            return arr[0];
        }

        //checking if ele  at last index is our answer
        if(arr[arr.length - 2] != arr[arr.length - 1]) {
            return arr[arr.length - 1];
        }

        //now apply bs in 1 to second last index
        int low = 2;
        int high =  arr.length - 3;

        //as agar last index ya 1st index answer hai, toh wahin se return ho gye
        //agar nhi ,then 0 and 1 are same, and last and second last are same
        //means woh hamaare ans nhi
        //hence start from 2 and end search at third last

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) {
                //this is our unique ele
                return arr[mid];
            }

            //check if mid is at the first position, meaning there are 2 positions of the number first and second
            //as it is appearing 2 times, hence here we only want that mid should be at the first place
            //for our logic to work

            if(arr[mid] == arr[mid - 1] ) {
                //means the mid is at its second position
                mid--;
            }

            //this step is necessarily to be done after checking for our ans i.e. line 40 - 43
            //o/w wrong ho jaayega

            if (mid % 2 == 0) {
                //now discard left
                low = mid + 2;
                //as + 1 se toh waapis wohi ele par aa jaayenge as we're on the first position
                // so  mid + 2 gives us the next number
                // mid + 1 karenge toh bhi wrong nhi hai as such bas TC jyada lega
            } else {
                //else means that you're at the right side of the array
                // and the unique ele is at the left side

                //now discard right
                high = mid - 1;
            }
        }

        return -1;


    }
}
