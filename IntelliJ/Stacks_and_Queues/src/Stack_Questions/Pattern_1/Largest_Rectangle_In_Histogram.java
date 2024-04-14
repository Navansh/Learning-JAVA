package Stack_Questions.Pattern_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Largest_Rectangle_In_Histogram {
    public static void main(String[] args) {
        //https://leetcode.com/problems/largest-rectangle-in-histogram/description/
    }

    public static int largestRectangleAreaOptimized(int[] heights) {
        Stack<Integer> stacker = new Stack<>();
        int ans = 0;

        for (int i = 0; i <= heights.length; i++) {
            //this below condition will only solve for those numbers who have
            //their NSE on Right available otherwise the condition for while
            //wont hit

            //but those ele will still be in stack
            int temp = 0;
            if(i == heights.length) {
                //this will help us create NSE on right for the last ele too
                //(which is currently in the stack )
                //as 0 will always be smaller than that last ele value
                //hence our while loop will run

                //this will also solve for all the indexes that have no
                //nse on right available as it is histogram hence every value
                //will be positive hence 0 will be obviously be smaller than them
                //hence our while loop will run and take that ans too

                temp = 0;
            } else {
                temp = heights[i];
            }

            while (stacker.size() > 0 && temp < heights[stacker.peek()] ) {
                //essentially the condition for calculating the nse on Right side

                //ith index is gonna solve for our top most ele at the stack
                //ele refers to the ele whose index is stored at the stack
                //but that's interchangeable as index can be used to cal value

                //hence the element to be solved is at our top
                int element_to_be_solved = stacker.pop();
                int nseRight = i;
                int x1 = nseRight - 1;
                //as i is the index


                //nseLeft calc we have to catch the edge case of no element in the stack
                int nseLeft = -1;
                //by default case when stack has no element left
                if(!stacker.isEmpty()) {
                    nseLeft = stacker.peek();
                }
                int x2 = nseLeft + 1;

                int area = heights[element_to_be_solved] * ( x1 -x2 + 1);
                ans = Math.max(area, ans);
            }

            stacker.push(i);
        }

        return ans;
    }

    public static int largestRectangleArea(int[] heights) {
        //firstly create the next smaller element on right (index) array
        //and for left also
        int[] nseRight = nseRightCalculator(heights);
        int[] nseLeft = nseLeftCalculator(heights);

        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < heights.length; i++) {
            //take the ith height and see how far can you expand its width
            int height = heights[i];
            int x1 = nseLeft[i] + 1;
            //this stores that index
            int x2 = nseRight[i] - 1;

            int width = (x1 - x2) + 1;

            int area = height * width;
            ans = Math.max(ans, area);

        }

        return ans;

    }

    private static int[] nseLeftCalculator(int[] heights) {
        int[] ans = new int[heights.length];
        Stack<Integer> unsolved_Stack = new Stack<>();

        for (int i = heights.length - 1; i >= 0; i--) {
            //check if there is element
            //now check if the current ele can become the answer for our
            //current ele at the top of the stack
            while (!unsolved_Stack.isEmpty() && heights[i] < heights[unsolved_Stack.peek()]) {
                //means this can be an ans for the the peeked ele of the stack
                //so make it the ans
                ans[unsolved_Stack.peek()] = i;
                //as we need to store the index
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
            ans[unsolved_Stack.pop()] =  -1;
        }

        return ans;
    }

    private static int[] nseRightCalculator(int[] heights) {
        int[] ans = new int[heights.length];
        Stack<Integer> unsolved_Stack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            //check if there is element
            //now check if the current ele can become the answer for our
            //current ele at the top of the stack
            while (!unsolved_Stack.isEmpty() && heights[i] < heights[unsolved_Stack.peek()]) {
                //means this can be an ans for the the peeked ele of the stack
                //so make it the ans
                ans[unsolved_Stack.peek()] = i;
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
            ans[unsolved_Stack.pop()] = heights.length;
            //as then it can go till the last valid index height that is heights.length - 1

        }

        return ans;
    }
}
