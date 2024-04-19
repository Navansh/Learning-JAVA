package Stack_Questions.Pattern_2_Adapters;

import java.util.Arrays;

public class K_Stacks_in_a_Single_Array {
    //https://www.naukri.com/code360/problems/n-stacks-in-an-array_1164271?topList=love-babbar-dsa-sheet-problems&leftPanelTab=0%3Fsource%3Dyoutube&campaign=Lovebabbarcodestudio11thfeb&count=25&page=1&search=&sort_entity=order&sort_order=ASC&attempt_status=NOT_ATTEMPTED
    public static void main(String[] args) {

    }
}

class kStacksSingleArray {
    int[] arr;
    int[] top;
    int[] next;
    int freespot;
    public kStacksSingleArray(int N, int S) {
        // ‘N’ stacks using a single array of size ‘S’.
        arr = new int[S];
        top = new int[N];
        next = new int[S];
        freespot = 0;

        //now initialize the default values of these arrays
        Arrays.fill(top,-1);
        
        //initialize next array
        for (int i = 0; i < next.length; i++) {
            next[i] = i + 1;
        }
        next[next.length - 1] = -1;
        //update the last index value to -1
    }


    // Pushes 'X' into the Mth stack. Returns true if it gets pushed into the stack, and false otherwise.
    public boolean push(int x, int m) {
        //check for stackOverflow condition
        if(freespot == -1) {
            return false;
        }

        //find the index to push
        int index = freespot;

        //update freespot
        freespot = next[index];

        //push the val
        arr[index] = x;

        //update the next array
        next[index] = top[m - 1];

        //update the top array
        top[m-1] = index;

        return true;
    }

    // Pops top element from Mth Stack. Returns -1 if the stack is empty, otherwise returns the popped element.
    public int pop(int m) {
        // We'll perform the similar as push operation but in reverse order

        //firstly check for the underflow condition
        if(top[m-1] == -1) {
            return -1;
        }

        int index = top[m-1];
        //this is the index of the topmost which is going to be popped

        top[m-1] = next[index];
        //now as the next array keeps the track of the next ele to be popped
        //so we update the top array for our stack with the next index that
        //is going to be popped

        //now update the next[index] that we are going to pop
        next[index] = freespot;

        freespot = index;

        return arr[index];
    }
    public int
}
