package Stack_Questions.Pattern_1;

import java.util.Stack;

public class Stock_span_problem {
    public static void main(String[] args) {

    }

    public static int[] calculateSpan(int arr[], int n) {
        //arr array represents the price array
        int[] ans = new int[arr.length];
        Stack<Integer> unsolved_Stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            //check if there is element
            //now check if the current ele can become the answer for our
            //current ele at the top of the stack
            while (!unsolved_Stack.isEmpty() && arr[i] > arr[unsolved_Stack.peek()]) {
                //means this can be an ans for the the peeked ele of the stack
                //so make it the ans

                //***************DIFFERENT for this ques********
                int difference = unsolved_Stack.peek() - i;
                ans[unsolved_Stack.peek()] = difference;
                unsolved_Stack.pop();
            }
            // else
            //meaning our stack is not empty but the ele we have is also smaller
            //hence it can't become the ans for the peeked ele of the stack
            //hence just push it to the stack

            //or this can be the base case also, for the first ele, of the array
            //when the unsolved_Stack is empty

            unsolved_Stack.push(i);
        }

        //now all the ele who have right greater ele must've have that in the answer
        //array by now, but if someone is still left in the stack, means it
        //doesn't have a right greater ele, by default the last ele of the array
        //will atleast be left in the stack without any ans

        //we may even use Arrays,fill(-1) in the start and fill rest with the answers
        //and just return the answer instead of doing this step
        //but this is more conceptual


        //******CATCH part here*********
        while (!unsolved_Stack.isEmpty()) {
            //take out the index and place -1 there
            int index = unsolved_Stack.peek();
            ans[index] = index + 1;
            unsolved_Stack.pop();
        }

        return ans;
    }
}
