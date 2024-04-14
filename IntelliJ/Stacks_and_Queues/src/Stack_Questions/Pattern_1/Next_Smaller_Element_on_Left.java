package Stack_Questions.Pattern_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Next_Smaller_Element_on_Left {
    public static void main(String[] args) {
        //https://www.geeksforgeeks.org/problems/smallest-number-on-left3403/1
        int[] arr = {1,6,2};
        System.out.println(leftSmaller(3, arr));

    }

    static List<Integer> leftSmaller(int n, int a[]) {
        List<Integer> ans = new ArrayList<>();
        //initialize all the ele for the list
        for (int i = 0; i < a.length; i++) {
            ans.add(-1);
        }
        Stack<Integer> unsolved_Stack = new Stack<>();

        for (int i = a.length - 1; i >= 0; i--) {
            //check if there is element
            //now check if the current ele can become the answer for our
            //current ele at the top of the stack
            while (!unsolved_Stack.isEmpty() && a[i] < a[unsolved_Stack.peek()]) {
                //means this can be an ans for the the peeked ele of the stack
                //so make it the ans
                ans.set(unsolved_Stack.peek(), a[i]);
                unsolved_Stack.pop();
            }
            // else
            //meaning our stack is not empty but the ele we have is also greater
            //hence it can't become the ans for the peeked ele of the stack
            //hence just push it to the stack

            //or this can be the base case also, for the first ele, of the array
            //when the unsolved_Stack is empty

            unsolved_Stack.push(i);
        }

        //now all the ele who have right smaller ele must've that in the answer
        //array by now, but if someone is still left in the stack, means it
        //doesn't have a right smaller ele, by default the last ele of the array
        //will atleast be left in the stack without any ans

        //we may even use Arrays,fill(-1) in the start and fill rest with the answers
        //and just return the answer instead of doing this step
        //but this is more conceptual

        while (!unsolved_Stack.isEmpty()) {
            //take out the index and place -1 there
            ans.set(unsolved_Stack.pop(), -1);
        }

        return ans;
    }
}
