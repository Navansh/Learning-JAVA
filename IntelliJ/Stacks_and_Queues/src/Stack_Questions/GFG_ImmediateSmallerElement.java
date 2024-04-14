package Stack_Questions;

import java.util.Arrays;
import java.util.Stack;

public class GFG_ImmediateSmallerElement {
    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 5, 3};
        immediateSmaller(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void immediateSmaller(int[] arr, int n) {
        // code here
        //if the right element is smaller, then update the current index to that element
        //else,
        //make it -1
        Stack<Integer> stackerr = new Stack<>();

        if(stackerr.isEmpty()) {
            stackerr.push(arr[0]);
        }

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < stackerr.peek()) {
                stackerr.push(arr[i]);
                arr[i-1] = arr[i];
            } else {
                stackerr.push(arr[i]);
                arr[i-1] = -1;
            }
        }

        arr[arr.length - 1] = -1;


    }
}
